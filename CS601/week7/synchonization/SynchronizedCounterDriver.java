package week7.synchonization;

public class SynchronizedCounterDriver {
    private SynchronizedCounter counter; // counter is synchronized in this case
    // because in SynchronizedCounter all increment and decrement method has synchronized keyword

    public SynchronizedCounterDriver(SynchronizedCounter counter) {
        this.counter = counter;
    }


    public class AdditionWorker implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        }

        /*
        so do not need to do synchronized (lock) in withSynchronization example
            for (int i = 0; i < 1000; i++) {
                synchronized (lock) {
                    x++;
                }
            }
         because in SynchronizedCounter, we already made count++ synchronized in increment method
         public synchronized void increment() {
            c++;
          }
        * */
    }

    public class SubtractionWorker implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                counter.decrement();
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedCounter counter = new SynchronizedCounter();
        SynchronizedCounterDriver dr = new SynchronizedCounterDriver(counter);
        Thread thread1 = new Thread(dr.new AdditionWorker());
        Thread thread2 = new Thread(dr.new SubtractionWorker());
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println(counter.value()); // should have this final value as 0
    }
}
