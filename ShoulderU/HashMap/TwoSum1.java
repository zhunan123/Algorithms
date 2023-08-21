package ShoulderU.HashMap;

import java.util.HashMap;

public class TwoSum1 {
  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int remaining = target - nums[i];
      if (map.containsKey(remaining)){
        return new int[]{i, map.get(remaining)};
      } else {
        map.put(nums[i], i);
      }
    }
    return new int[]{-1, -1};
  }
}
