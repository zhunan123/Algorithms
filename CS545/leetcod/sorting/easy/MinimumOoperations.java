package CS545.leetcod.sorting.easy;

import java.util.Arrays;

public class MinimumOoperations {
  /**
   * You are given a non-negative integer array nums. In one operation, you must:
   * Choose a positive integer x such that x is less than or equal to the smallest non-zero element in nums.
   * Subtract x from every positive element in nums.
   * Return the minimum number of operations to make every element in nums equal to 0.
   *
   *
   * Example 1:
   *
   * Input: nums = [1,5,0,3,5]
   * Output: 3
   * Explanation:
   * In the first operation, choose x = 1. Now, nums = [0,4,0,2,4].
   * In the second operation, choose x = 2. Now, nums = [0,2,0,0,2].
   * In the third operation, choose x = 2. Now, nums = [0,0,0,0,0].
   * */
  private int computeMinVal(int[] nums) {
    int j = 0;
    int minIndex;
    while (nums[j] == 0) {
      j++;
    }
    minIndex = j;
    for (int i = j + 1; i < nums.length; i++) {
      if (nums[i] != 0 && (nums[i] < nums[minIndex])) {
        minIndex = i;
      }
    }
    return nums[minIndex];
  }

  private int computeSum(int[] nums) {
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
    }
    return sum;
  }
  public int minimumOperations(int[] nums) {
    int count = 0;
    int sum;
    while ((sum = computeSum(nums)) != 0) {
      int minValue = computeMinVal(nums);
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] != 0) {
          nums[i] = nums[i] - minValue;
        }
      }
      count++;
    }
    return count;
  }

  public static void main(String[] args) {
    MinimumOoperations op = new MinimumOoperations();
    int[] nums = {1,5,0,3,5};
    op.minimumOperations(nums);
  }
}
