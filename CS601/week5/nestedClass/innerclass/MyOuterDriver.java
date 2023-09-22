package week5.nestedClass.innerclass;

public class MyOuterDriver {

    public static void main(String[] args) {
        // access outer class from outer the outerclass
        MyOuter outer = new MyOuter(2);
        MyOuter.MyInner inner = outer.new MyInner();
        inner.func();
    }
}
