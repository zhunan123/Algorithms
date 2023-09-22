package week5.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 Parameterized.class is the custom runner being used,
 which allows you to run a test method multiple times with different input values.
 * */
@RunWith(Parameterized.class)
public class CircleTest {

    // in this test, we can create Circle object with given radius

    private double inputRadius, expectedArea, expectedPerimeter;

    public CircleTest(double inputRadius, double expectedArea, double expectedPerimeter) {
        this.inputRadius = inputRadius;
        this.expectedArea = expectedArea;
        this.expectedPerimeter = expectedPerimeter;
    }

    @Test
    public void testArea() {
        System.out.println("area: ");
        // This is the delta value or tolerance. It indicates the allowable difference between expectedArea
        // and the computed area for the test to be considered passing.
        assertEquals(expectedArea, new Circle(inputRadius).area(), 0.0001);
    }

    @Test
    public void testPerimeters() {
        System.out.println("HERE, perimeter");
        assertEquals(expectedPerimeter, new Circle(inputRadius).perimeter(), 0.0001);
    }

    @Parameterized.Parameters (name = "area({0}) =  {1}, perimeter({0}) = {2}}")
    public static Iterable<Object[]> loadTestData() {
        List<Object[]> inputExpectedList = new ArrayList<>();
        inputExpectedList.add(new Object[]{1, Math.PI, 2 * Math.PI});
        inputExpectedList.add(new Object[]{3, 9 * Math.PI, 6 * Math.PI});
        return inputExpectedList;
    }
}
