package CS545.leetcod.sorting.easy;

import java.util.Arrays;

public class ArrayPartition {

  /**
   * Given an integer array nums of 2n integers, group these integers into n pairs (a1, b1), (a2, b2), ..., (an, bn) such
   * that the sum of min(ai, bi) for all i is maximized. Return the maximized sum.
   *
   * Example 1:
   *
   * Input: nums = [1,4,3,2]
   * Output: 4
   * Explanation: All possible pairings (ignoring the ordering of elements) are:
   * 1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
   * 2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
   * 3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
   * So the maximum possible sum is 4.
   * */

  public static int arrayPairSum(int[] nums) {
//    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 1; i++) { //bubble sort array
      for (int j = nums.length - 1; j > i; j--) {
        if (nums[j] < nums[j - 1]){
          int tmp = nums[j];
          nums[j] = nums[j - 1];
          nums[j - 1] = tmp;
        }
      }
    }
    int sum = 0;
    for (int j = 0; j < nums.length; j += 2) {
      sum += Math.min(nums[j], nums[j + 1]);
//      sum += nums[j];
    }
    return sum;
  }


  public static void main(String[] args) {
    int[] nums = {6, 2, 6, 5, 1, 2};
    // sort array and split into (1, 2), (2, 5), (6, 6) and find min of each pair, then add sum
    arrayPairSum(nums);
  }
}
