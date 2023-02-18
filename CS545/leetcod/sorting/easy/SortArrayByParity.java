package CS545.leetcod.sorting.easy;

public class SortArrayByParity {

  /**
   * Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
   * Return any array that satisfies this condition.
   *
   * Example 1:
   *
   * Input: nums = [3,1,2,4]
   * Output: [2,4,3,1]
   * Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
   * */

  public int[] sortArrayByParity(int[] nums) {
    int i = 0;
    int j = nums.length - 1;
    while (i < j) {
      while (i < j && nums[i] % 2 == 0) {
        i++;
      }
      while (i < j && nums[j] % 2 != 0) {
        j--;
      }
      if (i < j) {
        //swap i, j
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
        i++;
        j--;
      }
    }
    return nums;
  }
}
