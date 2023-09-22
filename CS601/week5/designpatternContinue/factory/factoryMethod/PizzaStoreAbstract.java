package week5.designpatternContinue.factory.factoryMethod;

import week5.designpatternContinue.factory.Pizza;

public abstract class PizzaStoreAbstract {

    /**
     make pizza store abstract,
     and for every child pizza store (for example NYPizzaStore) need to override createPizza method
     * */
    abstract PizzaAbstract createPizza(String item);

    public PizzaAbstract orderPizza(String type) {
        PizzaAbstract pizza = createPizza(type);
        System.out.println("--- Making a " + pizza.getName() + " ---");
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
