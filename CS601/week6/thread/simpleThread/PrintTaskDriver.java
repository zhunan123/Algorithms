package week6.thread.simpleThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class PrintTaskDriver {

    public static void main(String[] args) throws InterruptedException {
        // different way to create threads
        // #1 approach
        // created a class that implements Runnable, override run method,
        // create class object of this class,
        // create thread object and pass in the class object, call thread.start()
        Thread t1 = new Thread(new PrintTask(5), "Thread1");
        Thread t2 = new Thread(new PrintTask(5));
        t1.start();
        t2.start(); // start() will call run() inside the particular thread that is working with this particular task
        // main thread will wait till t1 and t2 finish than call Done.
        t1.join();
        t2.join();
        System.out.println("Done " + Thread.currentThread().getName()); // main
        System.out.println("----------------------------------------------------");
        // #2 approach anonymous method
        Thread t3 = new Thread() {
            final static private int n = 5;
            @Override
            public void run() {
                for (int i = 0; i < n; i++) {
                    System.out.println(i + " " + Thread.currentThread().getName());
                }
            }
        };
        t3.start();
        System.out.println("----------------------------------------------------");
        // #3 approach anonymous method with init
        Thread t4 = new Thread() {
            private int n;
            Thread init(int n) {
                this.n = n;
                return this;
            }
            @Override
            public void run() {
                for (int i = 0; i < n; i++) {
                    System.out.println(i + " " + Thread.currentThread().getName());
                }
            }
        }.init(5);
        t4.start();
        System.out.println("----------------------------------------------------");
        // #4 approach directly use Runnable and override run
        Runnable r = new Runnable() {
            private final static int num = 5;
            @Override
            public void run() {
                for (int i = 0; i < num; i++) {
                    System.out.println(i + " " + Thread.currentThread().getName());
                }
            }
        };
        Thread t5 = new Thread(r, "thread5");
        t5.start();
        System.out.println("----------------------------------------------------");
        // # 5 use Callable interface instead of Runnable interface
        Callable callable = new Callable() {
            private final static int num = 5;
            @Override
            public Object call() {
                return num;
            }
        };
        // need to create Future task first
        FutureTask<Integer> result = new FutureTask<>(callable);
        Thread t6 = new Thread(result);
        t6.start();
        try {
            System.out.println(result.get()); // I think will return Futruetask object which is num 5
        }catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println("----------------------------------------------------");
        // # 6 use customized class that extends Thread class
        class MyThread extends Thread {
            private int num = 3;
            public void run() {
                for (int i = 0; i < num; i++) {
                    System.out.println(i + " " + Thread.currentThread().getName());
                }
            }
        }
        MyThread t7 = new MyThread();
        t7.start();
    }

}
