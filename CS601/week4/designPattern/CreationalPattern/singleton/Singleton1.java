package week4.designPattern.CreationalPattern.singleton;

public class Singleton1 {
    /*
    The Singleton design pattern ensures there's only one instance of a class existed in the JVM,
    say you have multiple parts of application(threads) need to create instance of this class, we need to have synchronized to handle multi-thread cases to make sure
    thread safe like no racing condition and make sure only instance is created, no more 1 instance of this class can be created.
    * */

    public static Singleton1 singleton;
//    private stat

    public Singleton1() {

    }

    // need to do a static factory method getInstance() here since for Singleton 1 there's no constructor, will use static method to create instance of this class
    public static Singleton1 getInstance() {
        // demonstrate the issue, what is multi-threading?
//        if (singleton == null) {
//            singleton = new Singleton1();
//        }

        /** approach #1
         we can do:
         public static synchronized Singleton1 getInstance()
         not very good will kill multi-theading
         * */

        /** approach #2, still not best*/
        if (singleton == null) { // when 2 treads arrive at the same time,
            // for synchronized() must pass a lock into this, in this cass class itSelf is a lock, so need to pass Singleton1.class
            synchronized(Singleton1.class) { // because this synchronized syntax, 2 thread will enter this block one by one
                if (singleton == null) { // for second thread will check is singleton is still null, if not null do not create again
                    singleton = new Singleton1();
                }
            }
        }

        System.out.println("--------------------------------------------------------------------------------");
        // Notes:
        // method 1 - classic singleton           public class Singleton {}
        // Drawbacks: Not thread-safe. If multiple threads access the getInstance() method simultaneously when instance is null,
        // more than one instance can be created.
        class Singleton {
            private static Singleton instance;
            private Singleton() {}

            public static Singleton getInstance() {
                if (instance == null) {
                    instance = new Singleton();
                }
                return instance;
            }
        }

        System.out.println("--------------------------------------------------------------------------------");
        // method 2 - thread safe singleton
        /*  not so good - Synchronization introduces overhead. Every single call to getInstance() is synchronized and can be a performance issue,
        When we say, "Synchronization introduces overhead," we are referring to the additional time and resources required to manage the synchronization mechanism.
        Here's a breakdown of that statement:
        Overhead: When a thread tries to enter a synchronized block or method, it must first acquire a lock. If the lock is already held by another thread,
        the thread has to wait until the lock is released. Acquiring, releasing, and waiting for locks involves both time and system resources.
        This is what we call the "overhead" of synchronization.
        Every single call to getInstance() is synchronized: In the context of the Thread-Safe Singleton example, the getInstance() method is marked synchronized.
        This means every time this method is called—whether the instance exists or not—the thread must acquire a lock before entering the method.
        * */
        class Singleton2 {
            private static Singleton instance;

            private Singleton2() {}

            /*
            Synchronized Method:
                When a method is declared with the synchronized keyword in Java, it means that the method is synchronized on a specific lock object.
                In essence, before a thread can execute this method, it must first obtain this lock. If another thread already holds the lock,
                 the incoming thread must wait until the lock is released.
                 If no other thread currently holds this lock, the calling thread obtains the lock and enters the method.
                If another thread already holds the lock (because it's already executing the getInstance() method),
                 then the incoming thread will wait. It will be blocked until the lock is released.
            * */

            public synchronized static Singleton getInstance() {
                if (instance == null) {
                    instance = new Singleton();
                }
                return instance;
            }
        }

        System.out.println("--------------------------------------------------------------------------------");

        /* method 3 - Double-Checked Locking
        * disadvantage: Slightly complex due to double-checking.
        **/
        class Singleton3 {
            private volatile static Singleton instance;

            private Singleton3() {}

            public static Singleton getInstance() {
                if (instance == null) {
                    // for synchronized() must pass a lock into this, in this cas3 class itSelf(Singleton1.class) is a lock, so need to pass Singleton1.class
                    // only the thread who hold the this lock can enter this code block others has to wait
                    synchronized (Singleton3.class) {
                        if (instance == null) {
                            instance = new Singleton();
                        }
                    }
                }
                return instance;
            }
        }


        return singleton;

    }
}
