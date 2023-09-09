package week3.immutableDesign.Inheritance.Creature;

public class Human extends Creature{
    private String firstName;
    public Human(String greeting, String firstName) {
        super(greeting);
        this.firstName = firstName;
    }

    public void speak() {
        System.out.println("human firstname" + firstName + "says " + getGreeting());
    }
}
