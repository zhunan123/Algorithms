package ShoulderU.Array.july10;

import java.util.Arrays;

public class MaximumGap164 {
    public int maximumGap(int[] nums) {
        // need to have time complexity of O(n) this currently have nlogn
        Arrays.sort(nums);
        int maxGap = 0;
        for (int i = 1; i < nums.length; i++) {
            int currentGap = nums[i] - nums[i - 1];
            if (currentGap > maxGap) {
                maxGap = currentGap;
            }
        }
        return maxGap;
    }
}
