package week7.synchonization;

public class CalculatePrimsVolatile extends Thread{
    public static final int MAX_PRIMES = 1000000;
    public static final int TEN_SECONDS = 50;
    public volatile boolean finished = false; // make finished variables volatile
    // this volatile keyword can make finished = true earlier and can be shared to each thread.

    @Override
    public void run() {
        int[] primes = new int[MAX_PRIMES];
        int count = 0;

        for (int i = 2; count < MAX_PRIMES; i++) {
            if (finished) {
                break;
            }

            boolean prime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    prime = false;
                    break;
                }
            }

            if (prime){
                primes[count++] = i;
                System.out.println("Found prime: " + i);
            }
        }
    }

    public static void main(String[] args) {
        CalculatePrimsVolatile calculator = new CalculatePrimsVolatile();
        calculator.start();

        try {
            //System.out.println(Thread.currentThread().getName());
            Thread.sleep(TEN_SECONDS);
        } catch (InterruptedException e) {
            System.out.println("The thread was interrupted.");
        }

        calculator.finished = true;
    }
}
