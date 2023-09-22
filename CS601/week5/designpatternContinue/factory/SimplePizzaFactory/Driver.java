package week5.designpatternContinue.factory.SimplePizzaFactory;

import week5.designpatternContinue.factory.Pizza;

public class Driver {

    public static void main(String[] args) {

        // then here we are using dependency injection to combine factory and store
        // flow: from driver ---> store.orderPizza()---->goto factory(factory.createPizza())
        // --->go back to store---> go back to drive and deliver final pizza
        PizzaSimpleFactory factory = new PizzaSimpleFactory();
        PizzaStoreSimpleFactory store = new PizzaStoreSimpleFactory(factory);
        Pizza pizza = store.orderPizza("veggie");
        System.out.println("We ordered a " + pizza.getName() + "with following toppings: " + pizza.getToppings());
    }
}
