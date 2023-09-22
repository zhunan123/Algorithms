package week5.designpatternContinue.factory.factoryMethod;

public class Driver {
    public static void main(String[] args) {

        /**
         when we call orderPizza in NYPizzaStore, go pizzaStoreAbstract first to orderPizza,
         then it will go to NYPizzaStore to createPizza since in PizzaStoreAbstract the create Pizza is a abstract method
         means subclass need to override it.
         drive orderPizza()--->PizzaStoreAbstract.orderPizza()---->NYPizzaStore.createPizza()--->return pizza back to store
         * */
        PizzaStoreAbstract nyStore = new NYPizzaStore();
        PizzaAbstract pizza = nyStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + pizza.getName() + System.lineSeparator());

    }
}
