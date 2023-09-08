package week3.immutableDesign.Interface;

public class Philosopher implements Speaker {
    @Override
    public void speak() {
        System.out.println("Hello from professor");
    }

    public void pontificate() {
        System.out.println("Healthy diet must include only raw vegetables");
    }
}