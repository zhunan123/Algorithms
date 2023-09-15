package week4.designPattern.CreationalPattern.singleton;

public class BetterSingleton {
    // make single private static and this will make sure singleton only created once
    private static BetterSingleton singleton = new BetterSingleton(); // create this singleton when class load. and only create once since it is a static, then in below just return in getInstance function

    public BetterSingleton() {
    }

    public static BetterSingleton getInstance() {
        return singleton;
    }
}
