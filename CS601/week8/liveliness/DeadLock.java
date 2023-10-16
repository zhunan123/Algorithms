package week8.liveliness;

public class DeadLock {
    //A deadlock occurs when two or more threads are unable to proceed
    // because each thread is waiting for a resource that other thread holds then can release it's own lock
    // so threads are stuck in a situation where they cannot make any progress

    /**
     Deadlock Scenario:

     Both t1 and t2 have acquired a lock on one resource and are waiting for the other resource to be released.
     Thread t1 is waiting to lock resource2, which is held by thread t2.
     Thread t2 is waiting to lock resource1, which is held by thread t1.
     Neither thread can proceed because they are both blocking each other, resulting in a deadlock situation.
     * */

    public static void main(String[] args){
        //These are the two resource objects
        //we'll try to get locks for
        final Object resource1 = "resource1";
        final Object resource2 = "resource2";
        //Here's the first thread.
        //It tries to lock resource1 then resource2
        Thread t1 = new Thread() {
            public void run() {
                // t1 Lock resource 1
                synchronized(resource1){
                    System.out.println("Thread 1: locked resource 1");
                    //Pause for a bit, simulating some file I/O or
                    //something. Basically, we just want to give the
                    //other thread a chance to run. We are trying to force
                    //deadlock to happen here...

                    // During this sleep time, it holds the lock on resource1.
                    try {
                        Thread.sleep(50); // the lock is NOT released while the thread is sleeping
                    } catch (InterruptedException e) {}

                    //Now wait 'till we can get a lock on resource 2
                    // t1 will release lock on resources1 once exit the synchronized block, 前提is need lock on
                    // resources2 but will never get it since t2 has it
                    synchronized(resource2){
                        System.out.println("Thread 1: locked resource 2");
                    }
                }
            }
        };

        //Here's the second thread.
        //It tries to lock resource2 then resource1
        Thread t2 = new Thread(){
            public void run(){
                //This thread t2 locks resource 2 right away
                synchronized(resource2){
                    System.out.println("Thread 2: locked resource 2");
                    //Then it pauses, for the same reason as the first
                    //thread does
                    try{
                        Thread.sleep(50);
                    } catch (InterruptedException e){}

                    //Then it tries to lock resource1.
                    //But wait!  Thread 1 locked resource1, and
                    //won't release it till it gets a lock on resource2.
                    //This thread holds the lock on resource2, and won't
                    //release it till it gets resource1.
                    //Neither thread can run,
                    //and the program freezes up. Deadlock!
                    synchronized(resource1){
                        System.out.println("Thread 2: locked resource 1");
                    }
                }
            }
        };

        //Start the two threads.
        //If all goes as planned, deadlock will occur,
        //and the program will never exit.
        t1.start();
        t2.start();
    }
}
