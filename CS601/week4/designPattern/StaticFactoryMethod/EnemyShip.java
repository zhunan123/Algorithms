package week4.designPattern.StaticFactoryMethod;

import java.lang.reflect.InvocationTargetException;

public interface EnemyShip {
    void attack();

    // we can have static method in interface, but must implement the method
    static EnemyShip getInstance(String type) {
//        if (type.endsWith("UFOShip")) {
//            return new UFOShip();
//        } else if (type.endsWith("PirateShip")) {
//            return new PirateShip();
//        }
//        return null;

        // another way to create object from constructor is using reflection
        // this is static factory method
        try {
            //static method forName for build-in class Class, find the particular class
            Class cl = Class.forName(type);
            // create object for the class
            Object obj = cl.getDeclaredConstructor().newInstance();
            // downcast to type of the ship from object
            EnemyShip ship = (EnemyShip) obj;
            return ship;
        } catch (ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException e) {
            System.out.println(e);
        }
        return null;
    }
}
