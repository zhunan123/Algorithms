package week3.designPattern.Inheritance.Creature;

import java.util.ArrayList;
import java.util.List;

public class Driver {
    public static void main(String[] args) {

        // 1) Add 3 aliens and 2 humans to the creatures ArrayList.
        // FILL IN CODE
        List<Creature> lists = new ArrayList<>();
        Alien Alien1 = new Alien("Hello ALien1", "Mars");
        Alien Alien2 = new Alien("Hello ALien2", "Mars");
        Alien Alien3 = new Alien("Hello ALien3", "Mars");
//                Alien Alien4 = new Alien("Hello ALien4", "Mars");

        Human human1 = new Human("jack", "Hello Human1");
        Human human2 = new Human("marry", "Hello Human2");

        lists.add(Alien1);
        lists.add(Alien2);
        lists.add(Alien3);
        lists.add(human1);
        lists.add(human2);



        // 2) Iterate over the ArrayList, call speak() method for
        // each creature. Call fight() for each Alien
        // FILL IN CODE
        for (Creature creature : lists) {
            // this is polymorphism
            // alien will call alien speak and human will call human speak
            // polymorphism reference(general) if creature is pointing to alien, will point to alien, it will call alien speak()
            // if creature is pointing to to human, will ppoint to human.speak()
            creature.speak();

            if (creature instanceof Alien) {
                // only creatrue that is Alien should fight so need to downcast
                ((Alien) creature).fight();
                //alien.fight also ok, but nor good
                // or we can put fight() inside alien speak method, so we call speak() if is alien will print fight in the 35 line
            }
        }

//                Alien4.fight();

    }
}
