package week5.designpatternContinue.factory.factoryMethod;


public class NYPizzaStore extends PizzaStoreAbstract{
    @Override
    PizzaAbstract createPizza(String item) {
        if (item.equals("cheese")) {
            return new NYStyleCheesePizza();
        } else if (item.equals("pepperoni")) {
            return new NYStylePepperoniPizza();
        } else return null;
    }
}
