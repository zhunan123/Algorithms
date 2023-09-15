package week4.designPattern.StaticFactoryMethod;

import java.lang.reflect.Field;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Driver dr = new Driver();
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter your ship type: ");
        String type = sc.nextLine();
        String fullName = dr.getClass().getPackageName() + "." + type;
        System.out.println(fullName);

        EnemyShip myShip = EnemyShip.getInstance(fullName);
        if (myShip != null) {
            myShip.attack();
        }

        System.out.println("------------------------------------------------------------------");
        try{
            // do not use this as well will break encapsulation
            PirateShip p = new PirateShip("jack");
            Field privateField = PirateShip.class.getDeclaredField("name");
            System.out.println(privateField);
            // similar to getter & setter in this method, get the name field and we can change it
            privateField.setAccessible(true);
            String name = (String) privateField.get(p);
            System.out.println(name);
        } catch(IllegalAccessException | NoSuchFieldException e) {
            System.out.println(e);
        }
    }
}
