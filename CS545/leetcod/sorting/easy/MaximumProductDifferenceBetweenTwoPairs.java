package CS545.leetcod.sorting.easy;

public class MaximumProductDifferenceBetweenTwoPairs {

  /**
   * The product difference between two pairs (a, b) and (c, d) is defined as (a * b) - (c * d).
   * For example, the product difference between (5, 6) and (2, 7) is (5 * 6) - (2 * 7) = 16.
   * Given an integer array nums, choose four distinct indices w, x, y,
   * and z such that the product difference between pairs (nums[w], nums[x]) and (nums[y], nums[z]) is maximized.
   * Return the maximum such product difference.
   *
   * Example 1:

   * Input: nums = [5,6,2,7,4]
   * Output: 34
   * Explanation: We can choose indices 1 and 3 for the first pair (6, 7) and indices 2 and 4 for the second pair (2, 4).
   * The product difference is (6 * 7) - (2 * 4) = 34.
   * */

  public static int maxProductDifference(int[] nums) {
    //bubble sort
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = nums.length - 1; j > i; j--) {
        if (nums[j] < nums[j - 1]){
          int tmp = nums[j];
          nums[j] = nums[j - 1];
          nums[j - 1] = tmp;
        }
      }
    }
    return nums[nums.length - 1] * nums[nums.length - 2] - nums[0] * nums[1];
  }

  public static void main(String[] args) {
    int[] arr = {5,6,2,7,4};
    maxProductDifference(arr);
  }
}
