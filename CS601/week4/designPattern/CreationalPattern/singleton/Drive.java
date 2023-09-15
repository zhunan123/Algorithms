package week4.designPattern.CreationalPattern.singleton;

public class Drive {

    public static void main(String[] args) {
        Singleton1 s1 = Singleton1.getInstance();
        Singleton1 s2 = new Singleton1();
        System.out.println(s1.equals(s2));


        System.out.println("----------------------------");
        System.out.println(Singleton1.singleton);  // can we access to singleton static variables? can make singleton static variables public, but default we should make it private
        System.out.println("----------------------------");

        BetterSingleton bs1 = BetterSingleton.getInstance();
        BetterSingleton bs = new BetterSingleton();
        System.out.println(bs1);
        System.out.println(bs);
        System.out.println(bs1.equals(bs));
        // week4.designPattern.CreationalPattern.singleton.BetterSingleton@6d03e736 - bs1
        //week4.designPattern.CreationalPattern.singleton.BetterSingleton@568db2f2 - bs2
    }
}
