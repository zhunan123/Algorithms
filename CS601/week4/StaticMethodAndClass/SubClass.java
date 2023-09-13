package week4.StaticMethodAndClass;

public class SubClass extends SuperClass{

    // child class can override parent non-static method but not static method
    @Override
    public void func1() {
        System.out.println("func1, subclass version");
//        staticFunc1();
    }

    // child cannot override parent class static method, if i write @Override here will give me error
//    @Override, Method can not override method from its superclass
    // but it can have it's own static method even name is same as parent's static method
    public static void staticFunc1() {
        System.out.println("staticFunc1, subclass version");
    }
}
