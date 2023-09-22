package week5.designpatternContinue.factory;

public class CheesePizza extends Pizza {
    public CheesePizza() {
        setName("Cheese Pizza");
        setDough("Regular Crust");
        setSauce("Marinara Pizza Sauce");
        addTopping("Fresh Mozzarella");
        addTopping("Parmesan");
    }
}
