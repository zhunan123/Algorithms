package week5.designpatternContinue.decorator;

public class BeverageWithSoyMilk extends CondimentDecorator{

    public BeverageWithSoyMilk(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        return getBeverage().cost() + 0.15; //0.15 is the cost of soy milk we are adding
    }

    @Override
    public String getDescription() {
        return getBeverage().getDescription() + ", SoyMilk";
    }
}
