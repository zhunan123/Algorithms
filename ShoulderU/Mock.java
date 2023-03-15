package ShoulderU;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mock {

    /* --------------------------------1-------------------------------- */
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

    /* --------------------------------2-------------------------------- */
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

    public List<int[]> merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        int low = intervals[0][0];
        int high = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= high) {
                if (intervals[i][1] > high) {
                    high = intervals[i][1];
                }
            }else {
                res.add(new int[]{low, high});
                low = intervals[i][0];
                high = intervals[i][1];
            }
        }
        res.add(new int[]{low, high});

        for(int[] r : res) {
            System.out.println(Arrays.toString(r));
        }
        return res;
    }

    /* --------------------------------4-------------------------------- */
    /**
     * 4.一颗二叉树的后序遍历序列为DBFEGCA，中序遍历为DBAFECG，则先序遍历为（ ）
     * A. ABDCEFG
     * B. ADCDEFG
     * C. ADBFEGC
     * D. ABDCFEG
     * */

    /* --------------------------------5-------------------------------- */
    /**
     * 有一个有序表为{1，5，10，12，35，42，48，60，75，78，85，95，100}，当二分查找值为85的结点时，( )次比较后查找成功。
     * */

    /* --------------------------------6-------------------------------- */
    /**
     * 6.楼梯有10个阶梯,一次可以走一个、两个或三个阶梯,问有多少种上楼方式( )
     * */

    /* --------------------------------7-------------------------------- */
    /**
     * merge排序时间复杂度（），快排时间复杂度（），冒泡算法时间复杂度（）
     * */

    /* --------------------------------8-------------------------------- */
    /**
     * 栈的特点（），队列的特点（）
     * */

    /* --------------------------------9-------------------------------- */
    /**
     * 以下这段代码的时间复杂度是( )
     * void fun(int n){
     * int i=1;
     * while(i<=n)
     * i=i*2;
     * */





    public static void main(String[] args) {
        Mock mk = new Mock();
        int[] arr0 = {};
        int[] arr = {5, 7, 7, 8, 8, 10};
        int target = 5;

        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervals2 = {{1, 4}, {4, 5}};

//        mk.findStartEndPos(arr, target);
        mk.merge(intervals1);
        mk.merge(intervals2);
    }
}
