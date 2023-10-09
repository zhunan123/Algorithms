package week7.synchonization;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultithreadJsonCounter1 {

    ExecutorService poolManager = Executors.newCachedThreadPool();
    Object lock = new Object();
    int count;

    public class jsonCounterWorker implements Runnable {
        Path dir;
        int localCount;

        jsonCounterWorker(Path dir) {
            this.dir = dir;
        }

        @Override
        public void run() {
            try {
                DirectoryStream<Path> fileAndFolder = Files.newDirectoryStream(dir);
                for (Path path : fileAndFolder) {
                    if (Files.isDirectory(path)) {
                        jsonCounterWorker worker = new jsonCounterWorker(path);
                        poolManager.submit(worker);
                    } else {
                        if (path.toString().endsWith(".json")) {
                            localCount++;
                        }
                    }
                }
                updateCount(localCount);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void updateCount(int localCount) {
        count += localCount;
    }

    public synchronized int getCount() {
        return count;
    }

    public int traverseAndCount(String dir) {
        Path p = Paths.get(dir);
        jsonCounterWorker firstWorker = new jsonCounterWorker(p);
        poolManager.submit(firstWorker);

        return getCount(); // not good need to wait till all thread finished computing
    }

    public static void main(String[] args) {
        MultithreadJsonCounter1 counter = new MultithreadJsonCounter1();
        counter.traverseAndCount("input");
    }
}
