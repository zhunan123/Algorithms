package week8.waitnotify.foodDelivery.inefficient;

public class Delivery {

    public static class Customer implements Runnable {
        private Food food;

        public Customer(Food food) {
            this.food = food;
        }

        @Override
        public void run() {
            food.eat();
        }

    }


    public static class DeliveryGuy implements Runnable {
        private Food food;

        public DeliveryGuy(Food food) {
            this.food = food;
        }

        @Override
        public void run() {
            food.deliver();
        }
    }
}
