package week4.StaticMethodAndClass;

public class SuperClass {
    public SuperClass() {

    }

    public void func1() {
        System.out.println("func1, super class version");
//        staticFunc1();
    }

        // child cannot override this
    public static void staticFunc1(){
        System.out.println("staticFunc1, superclass version");
    }
}