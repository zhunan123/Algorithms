package ShoulderU.Array.july5;

import java.util.HashSet;

public class ContainsDuplicates217 {
  public boolean containsDuplicate(int[] nums) {
    HashSet<Integer> set = new HashSet<>();
    // Set<Integer> set = new HashSet<>(nums.length)
    for (int num : nums) {
      set.add(num);
    }
    if (nums.length == set.size()) {
      return false;
    }
    return true;
  }
}
