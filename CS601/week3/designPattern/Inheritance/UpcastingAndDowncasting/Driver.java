package week3.designPattern.Inheritance.UpcastingAndDowncasting;

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
        // its actyally Vehicle v2 = t1, so v2 is actually a truck object that point to truck t1 but have a type of Vehicle
        // so we can easily do (Truck)v2 to downcast v2 from type of Vehicle to truck since its pointing to truck object

        // what will happen? this will crash, why? Question:
        t2 = (Truck)v1;
        // will crash since v1 during run time has Vehicle type and point to a Vehicle object, it is not able to downcast to Truck type,

        /*
        This line attempts to cast v1, which is a reference to an instance of Vehicle, to a Truck.
        Since v1 does not actually reference a Truck object (it references a Vehicle object), this cast is invalid.
         Java will throw a ClassCastException at runtime when it encounters this line.

         For example, the line Truck t2 = (Truck)v2; is valid because v2 actually references a Truck object.
          But, v1 references a Vehicle object, which isn't an instance of Truck, so attempting to cast it to Truck results in an exception.
        * */
    }
}
