package week5.designpatternContinue.adapter;

public class CompositionTest {

    /**
     Composition is a design technique in which your class can
     have an instance of another class as a field of your class.
     * */
    public static void main(String args[]) {
        CompositionExample.Car car = new CompositionExample.Car();
        car.start();
    }
}
