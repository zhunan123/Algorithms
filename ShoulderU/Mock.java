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

    /* ----2---- */
    /**
     * 2.Merge Intervals
     * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
     * and return an array of the non-overlapping intervals that cover all the intervals in the input.
     *
     * Example 1:
     * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]Output: [[1,6],[8,10],[15,18]]Explanation:
     * Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
     * Example 2:
     * Input: intervals = [[1,4],[4,5]]Output: [[1,5]]Explanation: Intervals [1,4] and [4,5] are considered overlapping.
     * */

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        System.out.println(Arrays.toString(intervals));
        return intervals;
    }


    public static void main(String[] args) {
        Mock mk = new Mock();
        int[] arr = {5, 7, 7, 8, 8, 10};
        int target = 8;

        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervals2 = {{1, 4}, {4, 5}};

//        mk.findStartEndPos(arr, target);
        mk.merge(intervals1);
    }
}
