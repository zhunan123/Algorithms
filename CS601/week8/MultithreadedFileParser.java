package week8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class MultithreadedFileParser {
    // check how many files and what files contain the keyword arraylist
    private int count;
    private ExecutorService poolManager = Executors.newCachedThreadPool();
    private Phaser phaser = new Phaser();

    public class Worker implements Runnable {
        private Path file;
        private String keyword;
        private int localCount = 0; // number of lines in this file that contain the given keyword

        public Worker(Path file, String keyword) {
            this.file = file;
            this.keyword = keyword;
        }

        @Override
        public void run() {
            try (BufferedReader br = new BufferedReader(new FileReader(file.toString()))) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.contains(keyword)) {
                        System.out.println(file);
                        localCount++;
                    }
                }
            } catch (IOException e) {
                System.out.println("Cannot open" + file);
            }
            finally {
                updateCount(localCount);
                phaser.arriveAndDeregister();
            }

        }
    }

    public synchronized int getCount() {
        return count;
    }

    public synchronized void updateCount(int localCount) {
        this.count += localCount;
    }

    public void traverseDir(Path dir, String target) {
        try (DirectoryStream<Path> filesAndFolders = Files.newDirectoryStream(dir)) {
            for (Path path: filesAndFolders) {
                if (Files.isDirectory(path)) {
                    traverseDir(path, target);
                }
                else if (Files.isRegularFile(path) && path.toString().endsWith(".java")) {
                    Worker worker = new Worker(path, target);
                    poolManager.submit(worker);
                    phaser.register();
                }
            }
        } catch (IOException e) {
            System.out.println("Problem traversing a directory " + dir.toString());
        }
    }
    public int computeFrequency(String dir, String target) {
        Path p = Paths.get(dir);
        traverseDir(p, target);
        phaser.awaitAdvance(0);
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
        MultithreadedFileParser parser = new MultithreadedFileParser();
        System.out.println(parser.computeFrequency("CS601/week1/dataStructures", "ArrayList"));
    }
}
