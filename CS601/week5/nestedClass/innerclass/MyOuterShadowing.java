package week5.nestedClass.innerclass;

public class MyOuterShadowing {

    // outer member instance
    private int x = 2;
    private int y = 8;

    class InnerShadowing {

        private int x = 6; // Inner member instance

        private void print() {

            int x = 9; // local variable
            System.out.println(x); // 9, inner local variable
            System.out.println(y); // 8 outer class member variables
            System.out.println(this.x); // 6, innerclass member variables
            System.out.println(MyOuterShadowing.this.x); // 2, outer class member variables
        }
    }

    public static void main(String[] args) {
        MyOuterShadowing outer = new MyOuterShadowing();
        InnerShadowing inner = outer.new InnerShadowing();
        inner.print();

        // chain in 1 line
        MyOuterShadowing.InnerShadowing inner2 = new MyOuterShadowing().new InnerShadowing();
        inner2.print();
    }
}
