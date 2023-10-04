package week7.synchonization;

public class LockDemo {

    // Two worker threads:
    private final Thread worker1;
    private final Thread worker2;

    // Different types of locks
    private final static Object staticLock = new Object();
    private final Object outerLock;
    private final Object multiLock;

    /*
    *
    staticLock: A single lock for all instances of LockDemo.
    outerLock: A lock unique to each LockDemo instance.
    multiLock: Another lock unique to each LockDemo instance.
    this: The current instance of LockDemo itself can be used as a lock.
    new Object(): A new lock created for each Worker.
    * */

    public LockDemo(String name) {
        outerLock = new Object();
        multiLock = new Object();

        /* case #1
        *  Each worker has its own/lock or key
         So they do not need to compete for the locks - each of them can obtain a lock at the same time
         every thread has its own key so they will execute the task at some time and finish same time
         When both worker1 and worker2 have their unique locks which are outerLock and multiLock
         * Both threads can run simultaneously since they're not competing for the same lock.
        * */

        /*
        * for demo1 will have 2 worker threads, worker1 names A1 and worker2 named A2, A1 will have outerLock
        * A2 will have multiLock, so both thread will run simultaneously since they're not competing for the same lock
        * similar for demo2 will have 2 worker threads work1 named B1 and worker2 B2, and rest is same as demo1
        * so A1 is not competing with A2 and B1 is not competing with B2
        * also A do not need to compete with B since they different demo.
        * so A1,B1,A2,B2 will show result at same time
        * */
//          worker1 = new Worker(outerLock);
//          worker2 = new Worker(multiLock);


        /* case #2
         Both workers 1 and 2 of this instance of LockDemo get the same lock
         So workers need to compete for the lock
         so only have 1 locks/keys, A1 is competing with A2, and B1 is competing with B2
         but still have 2 demos, so A is not competing with B

         When both worker1 and worker2 share the same lock (outerLock or this)
         One(e.g. A2/B2) thread will wait for the other(A1,B1) to finish because they're trying to acquire the same lock.
         so first maybe show A1 B1 is finished, then show A2 B2 is finished
         */
        //  worker1 = new Worker(outerLock);
        //  worker2 = new Worker(outerLock);


        /* case #3
         Same case as before. Workers 1 and 2 of this instance of LockDemo
         compete for one lock, "this"
         so only have 1 locks/keys, A1 is competing with A2, and B1 is competing with B2
         but still have 2 demos, so A is not competing with B

         this: The current instance of LockDemo itself can be used as a lock.

         When both worker1 and worker2 share the same lock (outerLock or this)
         One(e.g. A2/B2) thread will wait for the other(A1,B1) to finish because they're trying to acquire the same lock.
         so first maybe show A1 B1 is finished, then show A2 B2 is finished
        */
//          worker1 = new Worker(this);
//          worker2 = new Worker(this);


        /* case #4
         There is only one lock for all workers for all instances of LockDemo
         So they all need to compete for this lock
         will only have 1 key/lock each work need to compute 1 by 1

         in this case, not only worker A1 is competing with worker A2, worker B1 is competing with worker B2
         worker Thread A is also competing with worker Thread B (thread created by demo1 is competing thread created by with demo2)
         All threads (A1, A2, B1, and B2) will compete for this single lock. Only one will run at a time.
         e.g. A1->B1->B2->A2
        * */
//         worker1 = new Worker(staticLock);
//         worker2 = new Worker(staticLock);



        /* case #5
         Each worker is initialized with a brand new lock
         So there is no competition between threads, they can each grab their own lock
         every thread has its own key so all result display in same time

         same as case 1, each thread for each only lock, no competing at all
         worker A1 is not competing with worker A2, worker B1 is not competing with worker B2
         and worker B1 and worker B2 is working simultaneously so no competing between 2 demos A and B.
        * */
          worker1 = new Worker(new Object());
          worker2 = new Worker(new Object());

        worker1.setName(name + "1");
        worker2.setName(name + "2");

        worker1.start();
        worker2.start();
    }

    public void joinAll() throws InterruptedException {
        worker1.join();
        worker2.join();
    }

    private class Worker extends Thread {

        private final Object lock;

        public Worker(Object lock) {
            this.lock = lock;
            // this.lock = new Object();
        }

        @Override
        public void run() {
            synchronized (lock) {
                System.out.println(this.getName() + ": " + Thread.holdsLock(lock));

                try {
                    // The thread will keep its lock while sleeping!
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }

            //System.out.println(this.getName() + ": " + Thread.holdsLock(lock));

        }
    }

    public static void main(String[] args) throws InterruptedException {
        LockDemo demo1 = new LockDemo("A");
        LockDemo demo2 = new LockDemo("B");

        demo1.joinAll();
        demo2.joinAll();

        /*
         * We have the following threads TRYING to run at the same time:
         *
         * +---LockDemo A---+  +---LockDemo B---+
         * | +-A1-+ +-A2-+  |  | +-B1-+ +-B2-+
         *
         * Whether A1, A2, B1, B2 are able to run simultaneously (e.g. threads
         * are able to enter the "locked rooms" setup by each thread) depends on
         * the type of lock used.
         */
    }
}
