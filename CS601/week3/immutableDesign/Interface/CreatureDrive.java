package week3.immutableDesign.Interface;

import java.util.ArrayList;
import java.util.List;

public class CreatureDrive {
    public static void main(String[] args) {
        Creature cr = new Creature();
        cr.say("hello");
        cr.shout();



        // since Creature implements Speak
        // what does that means?
        // cannot create object / instantiate of a interface Speak s = new Speak() not doable, because interface is just behavior that class can have, not a class
        // create a polymorphism reference, we can make it the type of variable to the name of the interface, it can point to any object/class that implement this interface
        // why do you want to make the type to a interface not just name of class, for flexibility like in Map interface contain TreeMap class or HashMap class or List interface contains ArrayList class, LinkedList class
        List<String> names = new ArrayList<>(); // List is a interface that implements of ArrayList class which implemented by data structure arrayList or linkedList or something else, also List can be implemented on LinkedList, so  List----->ArrayList(up t0 down)
        // when I make my type variable List, means programs to interface, early in the code you can point this name variable implement List interface to ArrayList class, later on if you want to change you can point it to LinkedList class, functionality will not change because both are same methods
        Speak cr2 = new Creature(); // like Speak is upper class, Creature is lower class that implements Speak, there's other class can implements Speak, Speak----->Creature
        cr2.say("hello"); // Creature version of say
        cr2.shout();// both Speak and Creature has method shout, cr2 has Type of Speak and has point to Creature object/class, Creature version of shout will depends on type of object not reference
    }
}
