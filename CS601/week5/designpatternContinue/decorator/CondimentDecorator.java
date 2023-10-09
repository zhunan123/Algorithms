package week5.designpatternContinue.decorator;

public abstract class CondimentDecorator extends Beverage{

    // decorator means we need to extend certain base abstract class
    // and add composition(need to add and store certain class instance variable in local variable)

    //Stores a Beverage instance (Composition):
    //While inheritance allows the decorator to be a Beverage,
    // composition allows the decorator to wrap or "decorate" a Beverage.
    // The contained Beverage instance can be a concrete beverage (like Decaf)
    // or another decorator (like BeverageWithMilk)

    //Composition:
    //Composition is an Object-Oriented Programming principle where a class is
    // composed of one or more objects from other classes
    private Beverage beverage; // composition means we are remember the base beverage we started with

    public CondimentDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    public abstract String getDescription();

    protected Beverage getBeverage() {
        return beverage;
    }
}
