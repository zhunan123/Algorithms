package ShoulderU.Array.May24;

import java.util.Arrays;

public class ThreeSumClosest16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestD = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                int currentD = Math.abs(currentSum - target);
                if (currentD < closestD) { // update the cloest distance if smaller
                    closestD = currentD;
                    res = currentSum;
                }
                // compare currentSum with the target. If currentSum is greater than the target,
                // it means you need to decrease the sum, so you move the right pointer one step to the left
                if (currentSum >= target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}
