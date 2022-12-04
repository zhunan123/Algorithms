package Sorting;

public class SecondMax {

    /**
     * 在数组中找到第二大的数
     * 例1：
     * 输入：[1,3,2,4]
     * 输出：3
     * 例2：
     * 输入：[1,1,2,2]
     * 输出：2
     * */

    public int secondMax(int[] nums) {
        int max = nums[0];
        int second = nums[1];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                second = max;
                max = nums[i];
            } else if (nums[i] <= max && nums[i] >= second) {
                second = nums[i];
            }
        }
        return second;
    }
}
