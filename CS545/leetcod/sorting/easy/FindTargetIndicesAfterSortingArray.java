package CS545.leetcod.sorting.easy;

import java.util.ArrayList;
import java.util.List;

public class FindTargetIndicesAfterSortingArray {
  /**
   * You are given a 0-indexed integer array nums and a target element target.
   * A target index is an index i such that nums[i] == target.
   * Return a list of the target indices of nums after sorting nums in non-decreasing order.
   * If there are no target indices, return an empty list. The returned list must be sorted in increasing order.
   *
   *
   * Example 1:
   *
   * Input: nums = [1,2,5,2,3], target = 2
   * Output: [1,2]
   * Explanation: After sorting, nums is [1,2,2,3,5].
   * */

  public List<Integer> targetIndices(int[] nums, int target) {
    //use insertion sort
    int j;
    int cur;
    for (int i = 1; i < nums.length; i++) {
      cur = nums[i];
      j = i - 1;
      while ((j >= 0) && nums[j] > cur) {
        nums[j + 1] = nums[j];
        j--;
      }
      nums[j + 1] = cur;
    }

    ArrayList<Integer> list = new ArrayList<Integer>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == target) {
        list.add(i);
      }
    }
    return list;
  }
}

