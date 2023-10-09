package week7.synchonization;

public class WithSynchronization {
    private int x = 0;
    private Object lock  = new Object(); // belongs to the outer class, will be shared by AdditionTask and SubtractionTask

    private class AdditionTask implements Runnable {

        @Override
        public void run() {
           /* Object lock  = new Object();// if we declaring the lock as local variable instead of creating lock as instance variable
             how does this change ? this is bad
             so we have 2 keys/locks in this case, each thread has its own keys, it does not provide synchronization, it will work as same
             as noSynchronization example works even tho has the synchronized keyword
             which means they will work on the task without wait for other thread to be finished
           */
            for (int i = 0; i < 1000; i++) { // with this for loop, we have the concurrency, but without the for loop, no concurrency at all, no racing condition
                /*
                 * use this synchronized, whichever the thread has the lock/key can enter this block this code with synchronized
                 * if one thread able to get the key/lock and get into the code other thread need to wait
                 * once this thread leave the block of synchronized code, it will release the key and other thread need to compete for the key
                 * */
                synchronized (lock) {
                    x++;
                }
            }
        }
    }

    private class SubtractionTask implements Runnable {
        @Override
        public void run() {
//            Object lock  = new Object();
            for (int i = 0; i < 1000; i++) {
                synchronized(lock) {
                    x--;
                }

            }
        }
    }

    public void createThreads() throws InterruptedException {

        /*
         * x++ and x-- are atomic
         * and result will always be 0, x will increment to 1000, then decrement to 0
         * so with synchronized we guarantee will get 0
         * */

        Thread t1 = new Thread(new AdditionTask());
        Thread t2 = new Thread(new SubtractionTask());
        t1.start();
        t2.start();
        // wait for threads 1 and 2 to  finish
        t1.join();
        t2.join();

        // Note: we are reading x below, but no need to synchronize here since t1 and t2 finished
        if (x != 0) // will only print something if x i not 0
            System.out.print(x + " ");
        // System.out.println("Done");
    }

    public static void main(String[] args)  {
        WithSynchronization ns = new WithSynchronization();
        try {
            // test for 1000 thread and see which thread don't have overall of 0
            // all test should have 0
            for (int i = 0; i < 10000; i++) {
                ns.createThreads();
            }
        }
        catch  (InterruptedException e) {
            System.out.println("Thread got interrupted: " + e);
        }
        System.out.println("Done");
    }

}
