package week5.designpatternContinue.factory.normalNaiveApproach_bad_without_factory_method;

import week5.designpatternContinue.factory.Pizza;

public class Driver {
    public static void main(String[] args) {
        PizzaStoreV1 store = new PizzaStoreV1();

        Pizza pizza = store.orderPizza("cheese");
        System.out.println("We ordered a " + pizza.getName() + "\n");

        System.out.println("with the following toppings: " + pizza.getToppings());
    }
}
