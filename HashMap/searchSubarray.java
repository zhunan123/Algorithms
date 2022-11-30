package HashMap;

import java.util.HashMap;

public class searchSubarray {

    /**
     * 给定一个数组arr和一个非负整数k，你需要从这个数组中找到一个连续子数组，使得这个子数组的和为k。
     * 返回这个子数组的长度。如果有多个这样的子串，返回结束位置最小的，如果还有多个，返回起始位置最小的。
     * 如果找不到这样的子数组，返回-1。
     *
     * 输入：arr=[3,-1,1,5,7,10,2] ，k=12
     * 输出：4
     * 解释：
     * 该数组中，最早出现的连续子串和为12的是[-1,1,5,7]。
     * */

    public int searchSubarray(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);

        int prefixSum = 0;
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            if (map.containsKey(prefixSum - k)) {
                return i - map.get(prefixSum - k);
            }
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }
        return -1;
    }
}
