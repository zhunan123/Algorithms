package week3.designPattern.Inheritance.Creature;

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
