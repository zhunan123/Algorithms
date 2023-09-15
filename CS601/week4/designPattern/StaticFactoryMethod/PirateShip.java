package week4.designPattern.StaticFactoryMethod;

public class PirateShip implements EnemyShip{
    String name;
    public PirateShip(String name1) {
        this.name = name1;
    }

    public void attack() {
        System.out.println("Pirate attack!");
    }
}
