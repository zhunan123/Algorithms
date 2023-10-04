package week7.VolatileKeyword;

import java.util.concurrent.TimeUnit;

/* this stopThread will run even without the console because its adding the volatile keyword*/
/* all thread read to the main memory and all thread writes to the main memory*/
public class StopThreadVolatile {
    private static volatile boolean stopRequested;
    // this volatile keyword will make sure each thread will see the most recent changes made by main thread
    // each thread will read data from main memory instead their own cache

    public static void main (String[] args) {

        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested) {
                i++;
                // do not need console in this case will also stop the timer
            }
        });
        backgroundThread.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        }
        catch (InterruptedException e) {
            System.out.println("Thread was interrupted.");
        }

        stopRequested = true;
    }
}
