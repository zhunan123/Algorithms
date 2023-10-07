package week3.designPattern.Inheritance.Creature;

public class Alien extends Creature{
    private String planet;
    private static int numAlienFromMars = 0;
    public Alien(String greetings, String planet) {
        super(greetings);
        this.planet = planet;
        if (planet.equals("mars")) {
            numAlienFromMars++;
        }
    }

    public void speak() {
        System.out.println("Alien from " + planet + "says " + getGreeting());
    }

    public void fight() {
        if (planet.equals("Mars") && numAlienFromMars > 3) {
            System.out.println("lets fight!");
        } else {
            System.out.println("lets not fight");
        }
    }
}
