package week4.StaticMethodAndClass;

public class Drive {
    public static void main(String[] args) {
        SuperClass sup1 = new SuperClass();
        SuperClass sub1 = new SubClass(); // will call children version, so have sub1 as varible name of type superclass but point to subclass class
        SubClass sub2 = new SubClass();


         sup1.func1(); // parent version
         sub1.func1(); // child version
        System.out.println("-------------------------------------------------------------------------------------");

        /* important: if we have staticFunc1 inside subclass func1, will staticFunc1 call parent version or child version*/
        sub1.func1(); // child version since it's already in subclass
        /**
         since sub1 points to subclass, go to subclass func1, then will goto subclass staticFunc1
         so if you already in parent class and called staticFunc1 will call parent version of staticFunc1
         if you in sub class and called staticFunc1 will call child version of staticFunc1
         * */
        System.out.println("-------------------------------------------------------------------------------------");

        /** if child do not override func1, so we remove func1 in subclass and add staticFunc1 inside superclass Func1 and see what sub1.func1() happened*/
        sub1.func1();
        /**
         since we do not have func1 in subclass, will call superclass func1, and will call staticFunc1 of parent version becasue already in parent class
         since calling which static method is based on which class you in
         * */
        System.out.println("-------------------------------------------------------------------------------------");

        // we can also call static method like this since it belong to the class
        SuperClass.staticFunc1(); // so in this case we do not need to instantiate it, will call parent version

        System.out.println("-------------------------------------------------------------------------------------");

        /** this below will call the parent version*/
        SuperClass sub3 = new SubClass();
        // parent version  - since for static method calling/binding happens at compile time means it will point to type of reference, so sub3.staticFunc1() will call parent version
        sub3.staticFunc1(); // parent version since staticFunc1 is static method, and will call the staticFunc1 inside superclass.
        sub3.func1(); // child version since Func1 is non-static method ;
        /**
            for static method, binding happens at compile time based on type of reference,
            means the compilers find sub3 has type of superclass, so will call staticFunc1 in parent version
            but for non-static method, when we call fun1() will print child version
         * */

    }
}
