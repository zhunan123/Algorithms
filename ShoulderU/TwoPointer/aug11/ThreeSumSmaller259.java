package ShoulderU.TwoPointer.aug11;

import java.util.Arrays;

public class ThreeSumSmaller259 {
  public int threeSumSmaller(int[] nums, int target) {
    // 0,1,2,3,4,5 || 7
    Arrays.sort(nums);
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      int left = i + 1, right = nums.length -1;
      while (left < right) {
        if (nums[i] + nums[left] + nums[right] < target) {
          // this is key say 0, 1, 5 = 6 < 7, then 012,013,014,015 all counts which is right - left
          count += right - left;
          left++;
        } else {
          right--;
        }
      }
    }
    return count;
  }
}
