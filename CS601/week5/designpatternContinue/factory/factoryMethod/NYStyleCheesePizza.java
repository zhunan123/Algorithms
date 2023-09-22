package week5.designpatternContinue.factory.factoryMethod;

public class NYStyleCheesePizza extends PizzaAbstract{

    public NYStyleCheesePizza() {
        setName("NY Style Sauce and Cheese Pizza");
        setDough("Thin Crust Dough");
        setSauce("Marinara Sauce");

        addTopping("Grated Reggiano Cheese");
    }
}
