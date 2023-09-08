package week3.immutableDesign.Interface;

public class Creature implements Speak {

    @Override
    public void say(String greetings) {
        System.out.println(greetings);
    }

//or you comment out this below and don't want override the shout() and just call the default and will call default shout() in Speaker
    @Override
    public void shout() {
        System.out.println("yell!");
    }


    @Override
    public String toString() {
        return "ok";
    }
}
