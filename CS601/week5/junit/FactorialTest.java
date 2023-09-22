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
public class FactorialTest {
    private int inputN;
    private int expectedFactorialResult;

    public FactorialTest(int n, int expected) {
        this.inputN = n;
        this.expectedFactorialResult = expected;
    }

    @Test
    public void testCompute() {
        assertEquals(expectedFactorialResult, Factorial.compute(inputN));
    }

    @Parameterized.Parameters(name = "factorial({0}) = {1}")
    public static Iterable<Object[]> loadTestData() {
        List<Object[]> inputExpectedList = new ArrayList<>();
        inputExpectedList.add(new Object[]{0, 1}); // 0 is n, 1 is factorial(n)
        inputExpectedList.add(new Object[]{1, 1});
        inputExpectedList.add(new Object[]{2, 2});
        inputExpectedList.add(new Object[]{3, 6});
        inputExpectedList.add(new Object[]{4, 24});
        return inputExpectedList;

    }
}
