package week5.nestedClass.AnonymousClass;


import week3.designPattern.Interface.Creature;

public class CreatureExample {

    public static void main(String[] args) {
        // create anonymous subclass with no name that extends Creature class while not
        // creating the parentClass/Creature instantiate
        // do not need to instance of Creature class
        // anonymous class cannot have a constructor, below 2 example is how to create sub-anonymous-class without passing a constructor

        /**  IMPORTANT------>
         shows a way to pass parameters to the object of a anonymous class.
         a anonymous class cannot have explicit constructors, so below is how to initialize object
         how to initialize object without a constructor
         * */

        // use anonymous method to create a Creature instance without pass to parent class' constructor since anonymous class cannot have constructor as well
        Creature c = new Creature() { // example 1
            String name;
            // cannot have constructor,
            // but can have a similar method called init(), then how to call it ?
            public Creature init(String name) {
                this.name = name;
                return this;
            }
            @Override
            public void say(String greeting) {
                System.out.println("I am anonymous: " + greeting);
            }
        }.init("Alien Allen");


        System.out.println("---------------------");
        // example 2
        // use a local variable
        final String name1 = "Alien Allen";
        Creature c2 = new Creature(){
            String nameCreature = name1;
            @Override
            public void say(String greeting) {
                System.out.println("I am anonymous: " + greeting + "myname: " + nameCreature);
            }
        };
    }
}
