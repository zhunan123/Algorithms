package week7.synchonization;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultithreadJsonCounter {
    private int count;
    private ExecutorService poolManager = Executors.newCachedThreadPool();
    // create a lock
    private Object lock = new Object();

    // need to have a thread work for count each directory, make it static since do not need to access outside the inner class
    // not static since inner class need to access poolManager in this case
    public class JsonCounterWorker implements Runnable{ // why not callable? since in this case we dont want to return anything
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
                        // want to create a new worker
                        JsonCounterWorker worker = new JsonCounterWorker(path);
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
        this.count += localCount;
    }

    public int traverseDirectoryAndCountFiles(String directory) {
        Path dir = Paths.get(directory);
        JsonCounterWorker firstWorker = new JsonCounterWorker(dir);
        poolManager.submit(firstWorker);

        //return the total count once all the worker thread finished
        // return count; dont want to do that does not means all done, need some mechanism that check if all down
        // count is shareable, also synchronize access to count while read it and update it

        int c = getCount();
        return c;
    }

}
