package week7.synchonization;


/*
* The main issue is that the increment (x++) and decrement (x--)
* operations are not atomic
* */
public class NoSynchronization {
    private int x = 0;

    private class AdditionWorker implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++)
                x++;
        }
    }
    private class SubtractionWorker implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++)
                x--;
        }
    }

    public void createThreads() throws InterruptedException {
        Thread t1 = new Thread(new AdditionWorker());
        Thread t2 = new Thread(new SubtractionWorker());
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        /*
        * if operation is atomic, x should be 0 since first call additionThread to add up x to 1000
        * then call subtractionThread which subtract x to 0
        * since it's not synchronized, the race condition will happen, x will might not be 0
        * */
//        System.out.println(x);
        if (x != 0){
            // this will print out the thread that number of x is not 0
            System.out.print(x + " ");
        }
//         System.out.println("Done");
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            NoSynchronization ns = new NoSynchronization();
            ns.createThreads();
        }
    }
}
