package week8.waitnotify.foodDelivery.efficient;

public class Food {
    private String name;
    private boolean isFoodDelivered = false;

    public Food(String name) {
        this.name = name;
    }

    /**
     customer and deliverguy work shared only 1 lock which is Food instance, since both
     of these worker has Food instance pass to their runnable construstor and call either food.eat()
     or food.deliver()

     -> there is indeed only one lock associated with the Food object because both the "customer1" and
      "delivery guy" threads are synchronizing on the same Food instance using synchronized(this).

     -> a thread releases its lock when wait() is called, wait() must be called on the lock object(synchronized(this)) in a synchronized block.
        and need to acquired a lock at first

     -> wait() and notify() should be in the same object instance, in this case is Food class instance
        and work on a shared data this case is isFoodDelivered variable

     -> custom1 thread is in waiting state and will not keep checking if boolean is true until
        notify() is called to wake them up better than busy waiting since busy waiting is inefficient

     -> notify() need also called on lock object in a synchronized block and only 1 waiting thread woken up by notify()

     -> You should always wait while checking
        synchronized(lock) {
            while (!condition) {
                lock.wait();
            }
        }

     * */

    public void eat() throws InterruptedException {
        synchronized(this){ // this line is acquiring lock
            System.out.println(Thread.currentThread().getName() + " got the lock for the synchronized block1");

            while (!isFoodDelivered){
                System.out.println("Waiting for delivery....and releasing lock while waiting...");
                // this is called on current instance Food Object
                /**
                 When this.wait() is called, it means the current thread is releasing the lock
                 associated with the current Food object(this) and going into a waiting state until
                 another thread calls notify() or notifyAll() on the same Food object to wake it up.
                 * */
                this.wait(); // this is lock in this case, lock is Food instance
                System.out.println(Thread.currentThread().getName() + " got notified and got the lock");
            }
        }
        System.out.println(Thread.currentThread().getName() + "Released the lock. Eating now...");
    }

    public void deliver(){
        synchronized(this){ // this line is acquiring lock
            System.out.println(Thread.currentThread().getName() + " got the lock for the synchronized block2");
            this.isFoodDelivered = true;
            System.out.println("Food delivered");
            /**
             notify(): Wakes up one of the waiting threads that called wait() on the same object.(here same object means Food instance, custom worker thread called this.wait() on Food instance, so this.notify() will wake it up)
             notifyAll(): Wakes up all waiting threads that called wait() on the same object.

             after called this.notify(), deliverGuy thread will release lock (will release on line 76 not 73, means release the lock when thread exits synchronized block), then will go to awaken this.wait() thread
             and process what's next after this.wait()

             "delivery guy" thread calls notify() after delivering the food,
             and this wakes up the "customer1" thread from its waiting state.
             * */
            this.notify();
            //this.notifyAll();
        }
        System.out.println(Thread.currentThread().getName() + " released the lock");
    }
}
