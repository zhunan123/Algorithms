package week5.nestedClass.innerclass;

public class MyOuter {
    private int var1;

    public MyOuter(int var1) {
        this.var1 = var1;
    }

    // if You don't declare access modifier, class will be package-private, means class can be access within the package
    // this inner class MyInner declared with default visibility means package private
    class MyInner {
        private int var = 10;

        void func () {
            System.out.println("inner: " + var);
            System.out.println("access outer: " + var1);
        }
    }

    public static void main(String[] args) {
        // can access inner here because still in outer class, but have to do outer.new Inner()
        // also inner class can access outerclass variables
        MyOuter outer = new MyOuter(2);
        MyOuter.MyInner inner = outer.new MyInner();
        // or you can do
        MyInner inner2 = outer.new MyInner();
        // or chain
        MyOuter.MyInner inner4 = new MyOuter(2).new MyInner();

        // or you can do below you have to make MyInner class static
//        MyOuter.MyInner inner3 = new MyOuter.MyInner();
//         if static class MyInner {}
        inner.func();
    }

//    public static void main(String[] args) {
//        // access outer class from outer the outerclass
//        MyOuter outer = new MyOuter(2);
    //        MyInner inner1 = outer.new MyInner(); need to put this main method in myOuter in order to have this line

//        MyOuter.MyInner inner = new MyOuter.MyInner(); // need to make MyInner class static inorder to do this

//        MyOuter.MyInner inner = outer.new MyInner();

//        MyInner inner1 = outer.new MyInner();

////        MyOuter.MyInner inner = new MyOuter.MyInner(); // need to make MyInner class static inorder to do this

//        inner.func();
//    }
}
