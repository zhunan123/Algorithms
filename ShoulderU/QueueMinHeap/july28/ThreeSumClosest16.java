package ShoulderU.QueueMinHeap.july28;

import java.util.Arrays;

public class ThreeSumClosest16 {
  public int threeSumClosest(int[] nums, int target) {
    int closest = Integer.MAX_VALUE;
    Arrays.sort(nums);
    int res = 0;
    for (int i = 0; i < nums.length; i++) {
      int current = nums[i];
      int left = i + 1, right = nums.length - 1;
      while (left < right) {
        int currentSum = current + nums[left] + nums[right];
        int diff = Math.abs(target - currentSum);
        if (diff < closest) {
          closest = diff;
          res = currentSum;
        }
        if (nums[left] + nums[right] > target - current) {
          right--;
        } else {
          left++;
        }
      }
    }
    return res;
  }
}
