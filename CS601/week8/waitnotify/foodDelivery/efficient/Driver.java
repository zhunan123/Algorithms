package week8.waitnotify.foodDelivery.efficient;

public class Driver {
    public static void main(String[] args) {
        Food food = new Food("Pasta Marinara");
        // creating 2 thread here which shared the same lock which is food instance
        Thread customer = new Thread (new Delivery.Customer(food), "customer1");
        // Thread anotherCustomer = new Thread (new FoodDelivery.Customer(food), "customer2");
        // Thread thirdCustomer = new Thread (new FoodDelivery.Customer(food), "customer3");

        Thread deliveryGuy = new Thread (new Delivery.DeliveryGuy(food), "delivery guy");
        customer.start();
        // anotherCustomer.start();
        // thirdCustomer.start();
        deliveryGuy.start();

        /**
         customer1 got the lock for the synchronized block1
         Waiting for delivery....and releasing lock while waiting...
         delivery guy got the lock for the synchronized block2
         Food delivered
         delivery guy released the lock
         customer1 got notified and got the lock
         customer1Released the lock. Eating now...

         flow is:
            -> customer1 thread acquire the lock(synchronized(this) on Food object) and go inside food.eat()
                -> printing "customer1 got the lock for the synchronized block1", finds out food is not delivered
                -> so called this.wait() to go into a waiting state and release the lock.
            -> then deliverguy acquire the lock and go inside food.deliver(), so will printing "delivery guy got the lock for the synchronized block2"
                -> make isFoodDelivered to true, print "Food delivered",
                -> then will call this.notify() to wake up customer1 thread from waiting state and release the lock and print "delivery guy released the lock"
            -> next will go back to custom1 this.wait() since its already waked, will print "customer1 got notified and got the lock"
            -> finally release the lock and print "customer1Released the lock. Eating now..."
         * */
    }
}
