package week7.synchonization;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;
/**
 * this version uses a Phaser as a synchronization barrier to ensure that all
 * threads have finished before proceeding.
 * */

public class MultithreadJsonCounterIWithPhaser {
    private int count;
    private ExecutorService poolManager = Executors.newCachedThreadPool(); // thread will be created as needed, will check if existed thread are enough, if not enough will create new thread
    // create a lock
    private Object lock = new Object();

    /*
    * phaser: An instance of Phaser, which is a flexible synchronization barrier.
    * Unlike CountDownLatch can only handle fixed number of threads,
    * a Phaser can handle a dynamic number of parties (threads).
    * */
    private Phaser phaser = new Phaser();

    // need to have a thread work for count each directory,
    public class JsonCounterWorker implements Runnable{ // Represents the worker thread responsible for traversing directories and counting .json files.
        private Path dir;
        private int localCount = 0;

        public JsonCounterWorker(Path dir) {
            this.dir = dir;
        }

        @Override
        public void run() {
            try (DirectoryStream<Path> filesAndFolders = Files.newDirectoryStream(dir)) {
                for (Path path: filesAndFolders) {
                    if (Files.isDirectory(path)) {
                        // want to create a new worker if is dir
                        JsonCounterWorker worker = new JsonCounterWorker(path); // will create a worker for each subdirectory
                        poolManager.submit(worker); // submit worker to executiveService, this new worker thread will now be responsible for traversing the subdirectory.
                        phaser.register(); // how phaser keep track all the worker, register thread to phaser
                        // It tells the phaser that there's a new worker thread that it should wait for
                        // TODO:
//                        logger.debug("Created a worker for " + path);
                    } else {
                        if (path.toString().endsWith(".json")) {
                            System.out.println(path);
                            localCount++; // each thread has its own, do not block each other thread
                        }
                    }
                }
                updateCount(localCount);
                // can do here as well but better not here
                // phaser.arriveAndDeregister();

            } catch (IOException e) {
                System.out.println(e);
            } finally {
                // will deregister here here instead of try after updateCount()
                phaser.arriveAndDeregister(); // arrive to certain barrier and wait for other thread to finish
                /*
                * he finally block ensures that, no matter what happens
                * (whether there's an exception or normal completion),
                * the worker will signal the phaser that it has finished its task using arriveAndDeregister().
                * This decrements the phaser's count, indicating one fewer party to wait fo
                * */
            }
        }
    }

    public synchronized int getCount () {
        // this also need to be synchronized, what will happen if getCount() not synchronized
        // will get the count while the count is updating,
        // will make sure getCount not able to get count while count is updating
        // synchronized is one thread is reading no other thread can change it
        return count;
    }

    public synchronized void updateCount(int localCount) {
        this.count += localCount; // combine localCount with bigger count which is the instance variable of JsonCounterWorker class
    }

    public int traverseDirectoryAndCountFiles(String directory) {
        Path dir = Paths.get(directory);
        JsonCounterWorker firstWorker = new JsonCounterWorker(dir);
        poolManager.submit(firstWorker);

        //return the total count once all the worker thread finished
        // return int c= getCount() and return c; dont want to do that does not means all done, need some mechanism that check if all down
        // count is shareable, also synchronize access to count while read it and update it
        // synchronization barriers(certain point in code to wait all of them to arrive), CountDownLatch and Phaser is 2 synchronization barrier
        // we have a group of runner/thread, theres certain checkout point they all meet,then after this main thread will move on
        // cannot use join() since join() need access to thread, we only have access to executorService
        // barrier method like CountdownLatchExample need to know number of runnable(number of files in this case), can only handle fixed number of thread

        // can user Phaser
        phaser.register(); // register the main thread with phaser
        // TODO: wait for all thread to finish to come to this barrier/finish line and move to next barrier
        // phaser is id of barrier that they are current working with,
        // the main thread will not moving to getCount until all thread that registered to phaser arrived at this certain barrier
        phaser.awaitAdvance(phaser.getPhase()); // main thread will need to wait all sub-thread to finish its task
        //It won't proceed until all other registered the workers have reached this barrier. Each party indicates its arrival at the barrier by calling arriveAndDeregister()

        /*
        * After all worker threads have finished, the ExecutorService (poolManager) is signaled to shut down,
        *  preventing it from accepting new tasks.
        *  The awaitTermination method is a safety measure to give running tasks a chance to finish.
        * */
        // but executorService will keep threads around will not shut down the threads
        poolManager.shutdown(); // shutdown means don't accept any more task from queue
        // normally we need to below code. let to existing working thread to finish then terminate, but we know we have the phaser, all thread should be done with their tasks.
        try {
            poolManager.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // then here we have make sure that all thread are done with its job, then we can getCount();
        int c = getCount();
        return c;
    }

}
