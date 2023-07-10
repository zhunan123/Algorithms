package ShoulderU.Array.july9;

public class SortColors75 {
  public void sortColors(int[] nums) {
    // using 2 pointer, first sort 0 and not 0, getting all 0's into front, then sort 1 and 2
    int low = 0, high = nums.length - 1;
    while (low < high) { //前面找不是0的，后面找是0的，然后交换位置，把0换到前面去
      while (low < high && nums[low] == 0) {
        low++;
      }
      while (low < high && nums[high] != 0) {
        high--;
      }
      // exchange
      if (low < high) {
        int temp = nums[low];
        nums[low] = nums[high];
        nums[high] = temp;
      }
    }
    // sort 1,2， 前面找是2的，后面找是1的，然后交换
    int start = low, end = nums.length - 1;
    while (start < end) {
      while (start < end && nums[start] != 2) {
        start++;
      }
      while (start < end & nums[end] != 1) {
        end--;
      }
      // exchange
      if (start < end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
      }
    }
  }
}
