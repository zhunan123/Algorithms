package week5.designpatternContinue.factory.SimplePizzaFactory;

import week5.designpatternContinue.factory.Pizza;

public class PizzaStoreSimpleFactory {
    /** Using a simple factory. This is better than PizzaStoreV1,
     *  we encapsulation/separate vary things(createPizza logic if statement) to another file(simplePizzaFactory)*/

    /*
    is creating a simple factory and pass dependency injection this simple factory into constructor
    of pizza store, and in orderPizza() call factory.createPizza() to go the createPizza() method
    in factory.
    * */
    private PizzaSimpleFactory factory;

    public PizzaStoreSimpleFactory(PizzaSimpleFactory factory) {
        this.factory = factory;
    }

    public Pizza orderPizza(String type) {
        Pizza pizza;

        // move createPizza logic in PizzaStoreV1 into another place called simple factory
        pizza = factory.createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
