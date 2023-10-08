package week3.designPattern.Interface;

import java.util.ArrayList;
import java.util.List;

public class SpeakingDriver {
    public static void main(String[] args) {
        Speaker speaker;
        speaker = new Philosopher(); // philosopher class is Speaker, true which Philosopher implements Speaker interface
        speaker.speak(); // Philosopher version

// line 7 and line 11m line is same but output is different, this is called polymorphism, means behavior will change for same code
        speaker = new Dog(); // dog overrides the Speaker interface, depends on the type of object here is Dog
        speaker.speak(); // Dog version

//        speaker.pontificate(); // this will have error, you are calling from Speaker, but in Speaker you dont have pontificate（） method,
        // pontificate() not existed in interface, but existed in class that implemented this interface, need to downcast
        // so you need to downcast from Speaker interface to Philosopher class
        ((Philosopher) speaker).pontificate(); // speaker is actually a Philosopher, during runtime, so pontificate is actually point to Philosopher class

        // otherwise can do regular
        Philosopher p = new Philosopher();
        p.pontificate();

        // polymorphism to loop different object/class with same interface
        List<Speaker> speakers = new ArrayList<>();
        speakers.add(new Dog());
        speakers.add(new Philosopher());

        for (Speaker s : speakers) {
            s.speak();

            if (s instanceof Philosopher) {
                //downcast speaker to Philosopher here
                // then call pontificate on s since it's pointing to Philosopher class
                // not very elegant
                ((Philosopher)s).pontificate();
            }
        }
    }
}
