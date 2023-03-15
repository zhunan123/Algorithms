package ShoulderU;

import java.util.Arrays;

public class Mock {

    /* ----1---- */
    /**
     * 1.Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
     * If target is not found in the array, return [-1, -1].
     * Example 1:
     * Input: nums = [5,7,7,8,8,10], target = 8Output: [3,4]
     * Example 2:
     * Input: nums = [5,7,7,8,8,10], target = 6Output: [-1,-1]
     * Example 3:
     * Input: nums = [], target = 0Output: [-1,-1]
     * */

    public int[] findStartEndPos(int[] arr, int target) {
        int[] res = {-1, -1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                if (res[0] == -1) {
                    res[0] = i;
                } else {
                    res[1] = i;
                }
            }
        }
        System.out.println(Arrays.toString(res));
        return res;
    }


    public static void main(String[] args) {
        Mock mk = new Mock();
        int[] arr = {5, 7, 7, 8, 8, 10};
        int target = 8;

        mk.findStartEndPos(arr, target);
    }
}
