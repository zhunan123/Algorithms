package week4.designPattern.CreationalPattern.singleton;

public class Singleton1 {

    public static Singleton1 singleton;
//    private stat

    public Singleton1() {

    }

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
            synchronized(Singleton1.class) { // because this synchronized syntax, 2 thread will enter this block one by one
                if (singleton == null) { // for second thread will check is singleton is still null, if not null do not create again
                    singleton = new Singleton1();
                }
            }
        }


        return singleton;
    }
}
