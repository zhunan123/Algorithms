package CS603.Week2;

import java.util.Arrays;

public class FindCloestElementInSortedArray {
  public int findCloestNum(int[] nums, int k) {
    Arrays.sort(nums);
    System.out.println(Arrays.toString(nums));
    int left = 0, right = nums.length - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (k == nums[mid]) {
        return nums[mid];
      }
      if (k < nums[mid]) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    if (k < nums[left]) {
      if (left ==0) {
        return nums[left];
      }
      if (Math.abs(nums[left] - k) > Math.abs(nums[left - 1] - k)) {
        return nums[left - 1];
      } else {
        return nums[left];
      }
    } else {
      if (right == 0) {
        return nums[right];
      }
      if (Math.abs(nums[left] - k) > Math.abs(nums[left + 1] - k)) {
        return nums[left + 1];
      } else {
        return nums[left];
      }
    }
  }

  public static void main(String[] args) {
    // 1, 3, 7, 9 ,13
    // [-17, -11, -5, 0, 2, 9, 21, 43, 75]
    int[] arr = new int[] {9, -17, -11, -5, 0, 2, 21, 43, 75};
    FindCloestElementInSortedArray fn = new FindCloestElementInSortedArray();
    int num = fn.findCloestNum(arr, 0);
    System.out.println(num);
  }
}
