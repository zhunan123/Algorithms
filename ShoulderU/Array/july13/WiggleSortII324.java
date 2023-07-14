package ShoulderU.Array.july13;

import java.util.Arrays;

public class WiggleSortII324 {
    public void wiggleSort(int[] nums) {
        // 排序 取中电和末点，然后加进array，然后中点末点往前移动，所以一定会是小大，小大。。。。
        // 偶数点就中点取值（因为小），基数点就末尾取值，因为大, 所以顺序一直是小大小大，而且不会遇见重叠问题
        // 因为第一个偶数点nums[mid]是小数左半边里最大的，就像是两条直线，左半边偶数点一直会小于右半边基数点

        Arrays.sort(nums);
        int[] res = new int[nums.length];
        int low = 0, high = nums.length - 1;
        int mid = low + (high - low) / 2;

        for (int i = 0; i < res.length; i++) {
            if (i % 2 == 0) {
                res[i] = nums[mid];
                mid--;
            } else {
                res[i] = nums[high];
                high--;
            }
        }

        for (int i = 0; i < res.length; i++) {
            nums[i] = res[i];
        }
    }
}
