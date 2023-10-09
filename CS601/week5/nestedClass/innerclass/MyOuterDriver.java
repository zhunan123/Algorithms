package week5.nestedClass.innerclass;

public class MyOuterDriver {

    public static void main(String[] args) {
        // access outer class from outer the outerclass
        MyOuter outer = new MyOuter(2);
        MyOuter.MyInner inner = outer.new MyInner();
//        MyInner inner1 = outer.new MyInner(); need to put this main method in myOuter in order to have this line
//        MyOuter.MyInner inner = new MyOuter.MyInner(); // need to make MyInner class static inorder to do this
        inner.func();
    }
}
