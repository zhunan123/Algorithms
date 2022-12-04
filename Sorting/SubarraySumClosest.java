package Sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubarraySumClosest {
    /**
     * 给定一个整数数组，找到一个和最接近于零的子数组。返回满足要求的子数组的起始位置和结束位置。
     * 你只需要考虑其中的一种可能性即可，具体可以参考样例。
     *
     * 输入:
     * [-3,1,1,-3,5]
     * 输出:
     * [0,2]
     * 解释: 返回 [0,2], [1,3], [1,1], [2,2], [0,4] 中的任意一个均可。
     *
     * 不使用 pair，不使用 TreeMap，只使用 HashMap + Array + Sort 的方法. 用 HashMap 记录之前的位置，用 Array 来打擂台找最小差距
     * 时间复杂度为O(nlogn), 空间复杂度为O(n)
     * */

    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        int[] results = new int[2];

        // edge case
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        if (nums.length == 1) {
            return new int[]{0,0};
        }

        // general
        Map<Integer, Integer> map = new HashMap<>();
        int[] prefixSum = new int[nums.length + 1];
        int sum = 0;
        map.put(0, -1);
        prefixSum[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                results[0] = map.get(sum) + 1;
                results[1] = i;
                return results;
            }
            map.put(sum, i);
            prefixSum[i + 1] = sum;
        }

        Arrays.sort(prefixSum);

        int minDiff = Integer.MAX_VALUE;
        int left = 0, right = 0;

        for (int i = 0; i < prefixSum.length - 1; i++) {
            if (minDiff > Math.abs(prefixSum[i] - prefixSum[i + 1])) {
                minDiff = Math.abs(prefixSum[i] - prefixSum[i + 1]);
                left = prefixSum[i];
                right = prefixSum[i + 1];
            }
        }
        if (map.get(left) < map.get(right)) {
            results[0] = map.get(left) + 1;
            results[1] = map.get(right);
        } else {
            results[0] = map.get(right) + 1;
            results[1] = map.get(left);
        }
        return results;
    }
}
