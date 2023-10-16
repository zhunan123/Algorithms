package week8.waitnotify.foodDelivery.inefficient;

public class Food {

    // first version, busy waiting, not efficient
    private String name;
    private volatile boolean isFoodDelivered = false;

    public Food(String name) {
        this.name = name;
    }

    public void eat() {
        /*
        In this code, there is a single thread(CustomerWorker thread) continuously checking the isFoodDelivered
         variable in a loop. This loop is known as "busy waiting."
         this customWorker thread is continuously checking and checking if isFoodDelivered is true..

         in busy waiting, the custom thread is alive and keep checking if boolean is true
        * */
        while (!isFoodDelivered) {
            System.out.println("Waiting for delivery...");
        }
        System.out.println("Eating...");
    }

    public void deliver(){
        this.isFoodDelivered = true;
        System.out.println("Food delivered");
    }
}
