package week5.designpatternContinue.decorator;

public class Decaf extends  Beverage{

    //A specific implementation of the Beverage component.
    //In your example, Decaf is a type of Beverage.

    public Decaf() {
        description = "Decaf Coffee";
    }

    public double cost() {
        return 1.05;
    }
}
