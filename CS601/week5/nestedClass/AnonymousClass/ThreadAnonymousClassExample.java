package week5.nestedClass.AnonymousClass;

public class ThreadAnonymousClassExample {
    /**
     shows a way to pass parameters to the object of a anonymous class.
     a anonymous class cannot have explicit constructors, we we discuss how to initialize object
     * */


   public static void main(String[] args) {
       // options 1
       Thread thread = new Thread() {
           // create a anonymous class that extends Thread class but not creating instance of Tread Class
           private int num;

           Thread init(int num) {
               this.num = num;
               return this;
           }
           @Override
           public void run() {
               // compute factorial of num 10
               int res = 1;
               for (int i = 1; i <= num; i++) {
                   res *= i;
               }
               System.out.println(res);
           }
       }.init(10);
        thread.start();


       //option 2
       final int n = 3;
       Thread thread2 = new Thread() {
           @Override
           public void run() {
               int res = 1;
               for (int i = 1; i <= n; i++) {
                   res *= i;
               }
               System.out.println(res);
           }
       };
       thread2.start();
   }
}
