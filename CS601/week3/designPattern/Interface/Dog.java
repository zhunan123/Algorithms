package week3.designPattern.Interface;

public class Dog implements Speaker {
    @Override
    public void speak() {
        System.out.println("Woof");
    }
}
