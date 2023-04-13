package ShoulderU.Array;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {
    /**
     * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
     *
     *
     *
     * Example 1:
     *
     * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
     * Output: [[1,6],[8,10],[15,18]]
     * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
     * */

    /**
     * has a currentInterval to keep track the current intervals,
     * add this currentInterval into res arraylist, then compare
     * with the intervals array,  if intervals[i][0] samller than
     * currentInterval, menas have overlap, then update the
     * currentInterval in res arraylist currentInterval[1] to
     * math.max(intervals[1] and currentInterval[1]) else,
     * means no overlap, so start a new currentInterval and
     * update currentInterval to intervals[i], and add this
     * newCurrentInterval into res arraylist
     * */

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, ((a, b) -> a[0] - b[0]));

        ArrayList<int[]> res = new ArrayList<>();
        int[] currentInterval = intervals[0];
        res.add(currentInterval);

        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] <= currentInterval[1]) {
                //有overlap 所以只用更新 之前的currentInterval 的值, 就不要再加入新的值
                currentInterval[1] = Math.max(intervals[i][1], currentInterval[1]);
            } else {
                //没有overlap所以要加入
                currentInterval = intervals[i];
                res.add(currentInterval);
            }
        }

        return res.toArray(new int[][]{});
    }

    public static void main(String[] args) {
        MergeIntervals merge = new MergeIntervals();
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        merge.merge(intervals);
    }
}
