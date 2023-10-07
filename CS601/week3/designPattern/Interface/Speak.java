package week3.designPattern.Interface;

public interface Speak {
    // any variable in interface will need to be assigned a initial value and is static and final
    static final int p = 10;
    void say(String greetings);
    // we can do abstract void say(String greetings) but this abstract is not needed

    default void shout() {
        System.out.println("Lets fight!!");
    }
}
