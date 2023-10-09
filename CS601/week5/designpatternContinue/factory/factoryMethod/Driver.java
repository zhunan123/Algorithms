package week5.designpatternContinue.factory.factoryMethod;

public class Driver {
    public static void main(String[] args) {

        /**
         when we call orderPizza in NYPizzaStore, go pizzaStoreAbstract first to orderPizza,
         than since in pizzaStoreAbstract has a abstract method createPizza(). so any class extends pizaStoreAbstract need to implement it
         then go to NYPizzaStyle that extends pizzaStoreAbstract need to implement vreatePizza
         and createPizza based on pizza type to instantiate either cheesePizza ot pepperoni pizza.
         then it will go to NYPizzaStore to createPizza since in PizzaStoreAbstract the create Pizza is a abstract method
         means subclass need to override it.
         drive orderPizza()--->PizzaStoreAbstract.orderPizza()---->PizzaStoreAbstract.createPizza()------>NYPizzaStore.createPizza()--->return pizza back to store
         * */
        PizzaStoreAbstract nyStore = new NYPizzaStore();
        PizzaAbstract pizza = nyStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + pizza.getName() + System.lineSeparator());

    }
}
