package ShoulderU.QueueMinHeap.july28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum18 {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 3; i++) {
      if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
        for (int j = i + 1; j < nums.length - 2; j++) {
          if (j == i + 1 || (j > i + 1 && nums[j] != nums[j - 1])) {
            int left = j + 1, right = nums.length - 1;
            long current = nums[i] + nums[j];
            long remaining = (long) target - current;
            while (left < right) {
              if (nums[left] + nums[right] == remaining) {
                result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                left++;
                right--;

                while (left < right && nums[left] == nums[left - 1]) {
                  left++;
                }
                while (left < right && nums[right] == nums[right + 1]) {
                  right--;
                }
              } else if (current + nums[left] + nums[right] > target) {
                right--;
              } else {
                left++;
              }
            }
          }
        }
      }
    }
    return result;
  }
}
