package week7.VolatileKeyword;

import java.util.concurrent.TimeUnit;

public class StopThreadWithoutVolatile {
    /*
    * this program does not stop, because this background thread only read data from it's own cache
    * it's not reading the most recent data change from the main thread
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
