package week7.synchonization;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// CountDownLatch is one of synchronization barriers in Java
public class CountdownLatchBarrierExample {
    /**
     * . CountdownLatch maintains a count, and threads can decrement this count using the countDown() method when each thread finished its task.
     * main thread will wait for this count to reach zero using the await() method.
     * */
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3); //initialize CountDownLatch with creating 3 threads that main thread will be waiting for
        // An ExecutorService named poolManager is created with a fixed thread pool of size 3.
        // This means the thread pool can simultaneously run a maximum of 3 threads.
        ExecutorService poolManager = Executors.newFixedThreadPool(3);// cannot use it to MultithreadJsonCounter
        // only if you know number of threads/file in this case, but we do not know how many files in MultithreadJsonCounter

        /*
        * Submitting Tasks:
        When you have a task (let's say a Runnable object), you can "submit" it to the ExecutorService
        * using the submit() method.
        Upon submission, the task enters a queue.
        The ExecutorService then takes care of selecting an available thread from its pool to execute this task.
        *  If all threads are currently busy and the pool can grow,
        * a new thread might be created to handle the task.
        * */
        for(int x = 0; x < 3; x++) { //Submitting Tasks to ExecutorService:
            //In the loop, three tasks (runnables) are submitted to the poolManager.
            // Each task simulates doing some work and then decrements the latch count by 1 using latch.countDown().
            poolManager.submit(() -> {
                // we are passing/submitting a class that implements runnable interface to executorService
                System.out.println("Pretend we are doing some work in this runnable");
                // once we finish the work with this runnable thread
                latch.countDown(); // finished the work, when they reached to this checkpoint,
                // decrement the count, then count = 0 means all thread are arrived
            });
        }

        try {
            // main thread cannot move pass this check point until all thread done their jobs means count = 0
            latch.await(); // wait for the count to be 0 -> wait for count = 0 means all runnable worker has done its job
            // The latch.await() method makes the main thread wait until the latch count reaches 0.
            System.out.println("Threads are done with tasks");
            //poolManager.shutdown();

        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
