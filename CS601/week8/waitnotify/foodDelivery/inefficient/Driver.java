package week8.waitnotify.foodDelivery.inefficient;

public class Driver {

    public static void main(String[] args) {
        /**
         To make it more efficient and reliable, you should use wait(), notify(), or notifyAll()
         methods along with proper locks,
         * */
        Food food = new Food("Pasta Marinara");
        // create customerWorker thread and deliveryGuyWorker thread
        Thread customerWorker = new Thread (new Delivery.Customer(food));
        Thread deliveryGuyWorker = new Thread (new Delivery.DeliveryGuy(food));
        customerWorker.start();
        deliveryGuyWorker.start();

        /**
         flow is create food-> create 2 thread customer and deliverGuy worker,
         --->pass the food into those 2 worker--->since isFoodDelivered is volatile,
         so both worker shared this same variable, Customer work only able to eat food if
         deliverGuy work call run() in when thread starts and change isFoodDelivered to true
         ----> but before deliveryGuy change isFoodDelivered to true, customWorker has to
         busy waiting which means checking isFoodDelivered again and again...
         * */
    }
}
