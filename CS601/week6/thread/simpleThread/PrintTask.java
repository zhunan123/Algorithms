package week6.thread.simpleThread;

public class PrintTask implements Runnable{

    private int n;

    public PrintTask(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        for(int i =  0; i < n; i++) {
            System.out.println(i + " " + Thread.currentThread().getName());
        }
    }
}
