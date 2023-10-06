package week7.synchonization;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultithreadJsonCounter {
    private int count; // holds total number of json file found
    private ExecutorService poolManager = Executors.newCachedThreadPool();
    // create a lock
    private Object lock = new Object();

    // need to have a thread worker for count each directory, make it static since do not need to access outside the inner class
    // not static since inner class need to access poolManager in this case
    public class JsonCounterWorker implements Runnable{ // why not callable? since in this case we dont want to return anything
        private Path dir;
        private int localCount = 0; // for each dir, the localCount stores count of json file that assigned thread worker found

        public JsonCounterWorker(Path dir) {
            this.dir = dir;
        }

        @Override
        public void run() {
            try (DirectoryStream<Path> filesAndFolders = Files.newDirectoryStream(dir)) {
                for (Path path: filesAndFolders) {
                    if (Files.isDirectory(path)) {
                        // want to create a new worker
                        JsonCounterWorker worker = new JsonCounterWorker(path);
                        // threads are created using the poolManager.submit(worker);
                        // where worker is an instance of the JsonCounterWorker
                        // This new worker is then submitted to the poolManager, which is the ExecutorService.
                        // This means a new thread will be allocated to run the worker's run() method.
                        poolManager.submit(worker);
                    } else {
                        if (path.toString().endsWith(".json")) {
                            System.out.println(path);
                            localCount++; // each thread has its own, do not block each other
                        }
                    }
                }
                updateCount(localCount);

            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    public synchronized int getCount () {
        return count;
    }

    public synchronized void updateCount(int localCount) {
        /*
        without synchronization mean if we have 2 thread, original global count is 7, 2 localCount for threadA and threadB is 5,8
        say A and B access global count simultaneously, A update count to 12, B update count to 15,
        instead should have count 7 + 5 + 8 = 20 instead of 15
        * */
        this.count += localCount;
    }

    public int traverseDirectoryAndCountFiles(String directory) {
        Path dir = Paths.get(directory);
        JsonCounterWorker firstWorker = new JsonCounterWorker(dir); // create the first thread worker to traverse the input dir
        poolManager.submit(firstWorker); // submit this runnable task to poolManage, and poolManager will assign available thread worker to work on this task

        //return the total count once all the worker thread finished
        // return count; dont want to do that does not means all done, need some mechanism that check if all down
        // count is shareable, also synchronize access to count while read it and update it

        /*
        so we don't want to do this
        this is immediately return without for all thread worker to finish, this could lead to incorrect result
        that is why we introduce phaser and another barrier called countDownLatch as a barrier in the MultithreadJsonCounterPhaser example
        we will have a barrier or a checkpoint where main thread will wait for each thread to finish then continue;

        int c = getCount();
        return c;
        */
        return 0;
    }

    public static void main(String[] args) {
        MultithreadJsonCounter multiThCounter = new MultithreadJsonCounter();
        System.out.println(multiThCounter.traverseDirectoryAndCountFiles("input"));
    }

}
