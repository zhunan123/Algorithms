package week8.waitnotify.blockingQueue;

import java.util.Random;

public class BlockingQueue {
    /**
     -> BlockingQueue: waiter and notifier need to
        agree on if queue is empty or full

     -> Blocks if trying to dequeue and it’s empty
        Blocks if trying to enqueue and it’s full

     -> BlockingQueue is a thread-safe, FIFO (First-In-First-Out) queue with blocking operations

     -> The key characteristic of a BlockingQueue is its ability to block (wait) when certain conditions are met,
        which allows threads to synchronize their activities efficiently.

     -> producer adds an element to the queue. If the queue is full, it blocks the calling thread until space becomes available with wait() and notifyAll()
        customer removes and returns an element from the queue. If the queue is empty, it blocks the calling thread until an element becomes available  with wait() and notifyAll().

     -> Capacity Limit: A BlockingQueue can have a specified capacity, meaning it can hold a maximum number of
        elements. When the queue is full, the add() operation blocks until space is available,
        helping to manage resource usage and prevent excessive memory consumption.
     * */

    /** Consumer thread removes elements from the queue */
    public static class Consumer implements Runnable {
        private BlockingQueueImplementation queue;

        public Consumer(BlockingQueueImplementation q) {
            queue = q;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    int elem = queue.dequeue();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /** Producer thread adds elements to the queue */
    public static class Producer implements Runnable {
        private BlockingQueueImplementation queue;
        private Random r;

        public Producer(BlockingQueueImplementation q) {
            queue = q;
            r = new Random();
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    int elem = r.nextInt(10);
                    queue.enqueue(elem);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        BlockingQueueImplementation q = new BlockingQueueImplementation(10);
        Thread thread1 = new Thread(new Consumer(q), "Consumer");
        Thread thread2 = new Thread(new Producer(q), "Producer");

        thread1.start();
        thread2.start();
    }
}
