package week7.synchonization;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class MultithreadJsonCounterPhaser {

    private int count;

    ExecutorService poolManager = Executors.newCachedThreadPool();
    Phaser phaser = new Phaser();


    public class Worker implements Runnable {
        int localCount = 0;
        Path dir;
        public Worker(Path dir) {
            this.dir = dir;
        }

        @Override
        public void run() {
            try {
                DirectoryStream<Path> files = Files.newDirectoryStream(dir);
                for (Path path : files) {
                    if (!Files.isDirectory(path) ) {
                        if (path.toString().endsWith("json")) {
                            localCount++;
                        }
                    } else {
                        Worker worker = new Worker(path);
                        poolManager.submit(worker);
                        phaser.register();
                    }
                }
                updateCount(localCount);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                phaser.arriveAndDeregister();
            }
        }
    }

    private synchronized void updateCount(int localCount) {
        count += localCount;
    }
    private synchronized int getCount() {
        return count;
    }


    public int traverseFiles(String dir) {

        Path p = Paths.get(dir);
        Worker worker = new Worker(p);
        poolManager.submit(worker);

        phaser.register();
        phaser.awaitAdvance(phaser.getPhase());

        poolManager.shutdown();

        int c = getCount();
        return c;
    }

    public static void main(String[] args) {
        MultithreadJsonCounterPhaser counter = new MultithreadJsonCounterPhaser();
        counter.traverseFiles("input");
    }
};
