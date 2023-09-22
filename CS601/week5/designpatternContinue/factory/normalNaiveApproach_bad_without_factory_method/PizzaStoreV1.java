package week5.designpatternContinue.factory.normalNaiveApproach_bad_without_factory_method;

import week5.designpatternContinue.factory.*;

public class PizzaStoreV1 {
    // this breaks open for extension, close for modification
    // not using factory method not simple factory - no good
    public Pizza orderPizza(String type) {
        Pizza pizza = null;

        if (type.equals("cheese")) {
            pizza = new CheesePizza();
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza();
        } else if (type.equals("clam")) {
            pizza = new ClamPizza();
        } else if (type.equals("veggie")) {
            pizza = new VeggiePizza();
        }
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
