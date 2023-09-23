package week5.designpatternContinue.decorator;

public class BeverageWithMilk extends CondimentDecorator{

    public BeverageWithMilk(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        return getBeverage().cost() + 0.10; // 0.10 is milk we adding
    }

    @Override
    public String getDescription() {
        return getBeverage().getDescription() + ", Milk";
    }
}
