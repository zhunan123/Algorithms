package week4.StaticMethodAndClass.UpcastingAndDowncasting;

public class Driver {

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle(4, 6, "01394234", "Ford");
        Truck t1 = new Truck(2, 2, "3254374", "Jeep", false);

        System.out.println(t1);
        System.out.println("---------------------------------------------------------");

        Truck.say(); // can call static method like this

        System.out.println("---------------------------------------------------------");
        // upcasting, v2 is Vehicle, v1 is Truck, left is parent class, right side is child class, we can do it implicitly or we can do explicitly
        // 看左边type是什么，时候upcasting 或者downcasting右边
        Vehicle v2 = t1; // normal implicitly, normally upcasting don't require explicit casting
        Vehicle v3 = (Vehicle)t1;  // explicitly

        // downcasting
        Truck t2 = (Truck)v2;

        // what will happen? this will crash, why? Question:
        t2 = (Truck)v1;
    }
}
