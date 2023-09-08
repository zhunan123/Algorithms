package week3.immutableDesign.Interface;

public class Dog implements Speaker {
    @Override
    public void speak() {
        System.out.println("Woof");
    }
}
