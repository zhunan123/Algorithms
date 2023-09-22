package week5.junit;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilTest {

    @Test
    public void testTrimConcatenate() {
        String res = StringUtil.trimConcatenate(" hell  o ", " wor, ld  ");
        String expected = "hell  owor, ld";
        assertEquals("The result is not what expected", expected, res);
    }

    @Test(expected = IllegalArgumentException.class)
    public void trimConcatenateNullException1() {
        String res = StringUtil.trimConcatenate(null, "abc");
    }

    @Test
    public void trimConcatenateNullException2() {
        try {
//            String res = StringUtil.trimConcatenate("hello", "abc"); // if this line no error, test will fail, because if hello is null, we are expecting a exception here
            String res = StringUtil.trimConcatenate(null, "abc"); // since this will throw exception, will not go to fail method
            // will go to catch#1 if it is a expected IllegalArgumentException
            fail("Error: IllegalArgumentException should have been thrown");

        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException is thrown as expected");
        } catch (Exception e) { // if not is IllegalArgumentException, will go to second catch, will fail the test again since it is a unkonw exception
            fail("Unknown exception is thrown.");
        }
    }

    @Test
    public void testSplitByCommasBasic() {
        String[] res = StringUtil.splitByCommas("This is a new day, a new beginning.");
        String[] expectedArr = {"This is a new day", " a new beginning."};
        assertArrayEquals(res, expectedArr);

    }
}
