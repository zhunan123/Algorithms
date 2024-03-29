package week3.designPattern.Inheritance.Creature;

public class Creature {
    private String greeting;

    public Creature(String greeting) {
        this.greeting = greeting;
    }

    public String getGreeting() {
        return greeting;
    }

    public void speak() {
        System.out.println("Creature says: " + greeting);
    }
}
