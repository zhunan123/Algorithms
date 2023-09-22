package week5.nestedClass.innerclass;

public class MyOuter {
    private int var1;

    public MyOuter(int var1) {
        this.var1 = var1;
    }

    // if You don't declare access modifier, class will be package-private, means class can be access within the package
    class MyInner {
        private int var = 10;
        void func () {
            System.out.println("inner: " + var);
            System.out.println("access outer: " + var1);
        }
    }

    public static void main(String[] args) {
        MyOuter outer = new MyOuter(2);
        // can access inner here because still in outer class, but have to do outer.new Inner()
        // also inner class can access outerclass variables
        MyInner inner = outer.new MyInner();
        inner.func();
    }
}
