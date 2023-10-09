package week5.designpatternContinue.decorator;

public class BeverageTest {
    public static void main(String[] args) {

        //adding new stuff on top of base decorator class
        // decorator means we need to extend certain base abstract class
        // and add composition(need to add and store certain class instance variable in local variable)
        Beverage beverage1 = new Espresso();
        System.out.println(beverage1.getDescription()
            + " $" + beverage1.cost());

        // this is cascading, Espresso base + add milk +
        // so every previous beverage will become base beverage and add new condiments
        // so the beverage1 will be override everytime with new condiments added
        // espresso 1.99 + milk 0.1 + soymilk 0.15 = 2.24 in totoal
        beverage1 = new BeverageWithMilk(beverage1);
        //new BeverageWithMilk---->getBeverage().cost in BeverageWithMilk---->
        //--->go to condimentDecorator since BeverageWithMilk extends CondimentDecorator
        //--->in condimentDecorator we have composition of current Beverage which is espresso
        // which espresso will have a base cost of 1.99
        System.out.println(beverage1.getDescription()
            + " $" + beverage1.cost());

        beverage1 = new BeverageWithSoyMilk(beverage1);
        System.out.println("$$$:" + beverage1.cost());

        System.out.println("------------------------------------");
        Beverage beverage2 = new BeverageWithMilk(new Decaf());
        System.out.println(beverage2.getDescription()
            + " $" + beverage2.cost());


        System.out.println("----------------------------------------------");

        //A concrete component like Decaf has a base cost.
        //You can wrap this concrete component with any number of decorators
        // (BeverageWithMilk, BeverageWithSoyMilk, etc.) to add additional functionality
        // and behavior.
        //Each decorator adds its own cost to the base cost of the beverage.
    }

}
