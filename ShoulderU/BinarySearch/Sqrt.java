package ShoulderU.BinarySearch;

public class Sqrt {

    /**
     * Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
     *
     * You must not use any built-in exponent function or operator.
     *
     * For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
     *
     *
     * Example 1:
     *
     * Input: x = 4
     * Output: 2
     * Explanation: The square root of 4 is 2, so we return 2.
     * Example 2:
     *
     * Input: x = 8
     * Output: 2
     * Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
     * */

    /**
     * need to consider 3 condition, x / mid == mid, x / mid < mid,  x / mid > mid,
     * why we have to use x / mid== mid isnteadf of mid * mid = x ??
     * */

    public int mySqrt(int x) {
        int low = 1;
        int high = x;

        if (x == 0) {
            return 0;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(x / mid == mid) { // i guess using it becasuse we can round the integer more easierly
                return mid;
            } else if (x / mid < mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }
}
