package week9;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MultithreadedJsonCounterWithAtomicInteger {
    //Atomic Integer itself provides synchronization
    private AtomicInteger count = new AtomicInteger(); // replace getCount() and updateCount()
    private ExecutorService poolManager = Executors.newCachedThreadPool();
//    private Logger logger = LogManager.getLogger();
    private Phaser phaser = new Phaser();

    public class JsonCounterWorker implements Runnable {
        private Path dir;

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
                        poolManager.submit(worker);
                        phaser.register();
//                        logger.debug("Created a worker for " + path);
                    }
                    else {
                        if (path.toString().endsWith(".json")) {
                            count.incrementAndGet();
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println(e);
            }
            finally {
                phaser.arriveAndDeregister();
//                logger.debug("Worker working on " + dir + " finished work");
            }

        }
    }

//    public synchronized int getCount() {
    public int getCount() { // do not need to be synchronized in this case because Atomic Integer itself provides synchronization
        return count.get();
    }

    public int traverseDirectoryAndCountFiles(String directory) {

        Path dir = Paths.get(directory);
        JsonCounterWorker firstWorker = new JsonCounterWorker(dir);
        poolManager.submit(firstWorker);
        phaser.register();
//        logger.debug("Created a worker for " + dir);

        phaser.awaitAdvance(phaser.getPhase());
        int c = getCount();
        poolManager.shutdown();
        try {
            poolManager.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        return c;
    }



    public static void main(String[] args) {
        MultithreadedJsonCounterWithAtomicInteger multiThCounter = new MultithreadedJsonCounterWithAtomicInteger();
        System.out.println(multiThCounter.traverseDirectoryAndCountFiles("input"));
    }
}
