package week9.sockets.lab7;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountdownLatchExample {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService poolManager = Executors.newFixedThreadPool(3);

        for(int x = 0; x < 3; x++) {
            poolManager.submit(() -> {
                System.out.println("Pretend we are doing some work in this runnable");
                latch.countDown(); // finished the work, decrement the count
            });
        }

        try {
            latch.await(); // wait for the count to be 0
            System.out.println("Threads are done with tasks");
            poolManager.shutdown();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
