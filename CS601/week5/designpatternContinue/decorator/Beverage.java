package week5.designpatternContinue.decorator;

public abstract class Beverage {

    /**
     This is the main abstract class/interface that defines the
     object to which additional responsibilities can be attached.
     In this case, Beverage provides a basic description
     and a method to calculate the cost.
     * */

    protected String description = "UnKnown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract  double cost();
}
