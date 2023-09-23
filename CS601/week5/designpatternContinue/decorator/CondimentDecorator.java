package week5.designpatternContinue.decorator;

public abstract class CondimentDecorator extends Beverage{

    // decorator means we need to extend certain base abstract class
    // and add composition(need to add and store certain class instance variable in local variable)

    private Beverage beverage;

    public CondimentDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    public abstract String getDescription();

    protected Beverage getBeverage() {
        return beverage;
    }
}
