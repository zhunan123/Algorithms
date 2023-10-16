package week8.waitnotify.blockingQueue;

import java.util.LinkedList;

public class BlockingQueueImplementation {
    private int capacity;
    private LinkedList<Integer> queue = new LinkedList<>();

    public BlockingQueueImplementation(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Waits until there is space in the queue, then adds an element to the queue
     * @param element the element to be added to the queue
     * @throws InterruptedException
     */
    public synchronized void enqueue(Integer element) throws InterruptedException {
        // FILL IN CODE:
        // if the queue is full, you need to wait
        // otherwise, add an element to the queue and notify everyone who is waiting on the queue
        while (queue.size() >= capacity) {
            /**
             use a while loop to continuously check if the queue is full
             If it's full, the thread waits using wait(). When space becomes available (another thread dequeues an element),
             it will be notified and wake up this thread and this thread will proceed to add the element to the queue
             * */
            this.wait();
        }
        queue.add(element);
        this.notifyAll();
    }

    /**
     * Waits until the queue has something to dequeue, then dequeues it and returns the element.
     * @return the first element from the queue
     * @throws InterruptedException
     */
    public synchronized Integer dequeue() throws InterruptedException {
        // If the queue is empty, need to wait
        // When the queue is not empty, we can dequeue an element and
        // notify everyone who is waiting on this queue
        Integer elem  = null;
        while (queue.size() <= 0) {
            /**
             use a while loop to continuously check if the queue is empty
             If queue empty, the current thread into a waiting state using wait(). When an element is enqueued (another thread adds an element),
             this will be notified and will be waked up and will proceed to dequeue and return the element.
             * */
            this.wait();
        }
        elem = queue.poll();
        this.notifyAll();

        return elem;
    }
}
