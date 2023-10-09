package week7.VolatileKeyword;

import java.util.concurrent.TimeUnit;

public class StopThreadWithoutVolatile {
    /*
    * this program does not stop, because this background thread only read data from it's own cache
    * it's not reading the most recent data change from the main thread
    * */

    /**
     By doing this, you ensure that any read or write operation to the stopRequested variable
     is done directly to and from the main memory, ensuring all threads see the most recent value.

     The Problem
     The issue here is memory visibility in multi-threaded environments.
     Without proper synchronization or the use of the volatile keyword,
     there's no guarantee that the backgroundThread will see the updated value of
     stopRequested after the main thread changes it.
     Java threads can cache variables, and without proper synchronization,
     they might not see the most recent changes made to these variables by other threads.
     * */

    /*
    In Java, volatile is a keyword used to declare a variable as volatile.
    When a variable is declared as volatile, it tells the JVM that multiple
    threads might access this variable, and it needs to be retrieved directly
     from the main memory, not from a thread's local cached memory.

     in this case, there are 2 thread which is main thread and backgroundThread try to acceess to
     this stopRequested variable, add volatile keywork to make sure any read or write operation
     is on main memory instead of thread's own cache.
    * */

    private static boolean stopRequested = false;

    public static void main(String[] args) {
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested) {
                i++; // will not stop, even though below we make stopRequested is true by main thread

                //but adding a console will stop
                /* because different thread might see different value of stopRequest,
                    main thread has is true, but the background thread see this still as false
                    this background thread cached this stopRequested variable in its own cache,
                    it did not see the stopRequested changed by main thread
                     so this console force background thread to update
                     the stopRequested value to true after main thread changed the stopRequested value
                 */
                System.out.println(stopRequested);
            }
        });
        backgroundThread.start();
        try{
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e) {
            System.out.println("thread is interrupted");
        }

        stopRequested = true; // this will not stop the while loop since background thread is not getting this main thread variable change
        System.out.println(stopRequested);
    }
}
