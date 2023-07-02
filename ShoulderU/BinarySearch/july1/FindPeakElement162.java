package ShoulderU.BinarySearch.july1;

public class FindPeakElement162 {
  public int findPeakElement(int[] nums) {
    //if num[mid] > nums[mid + 1],就往左边找，
    // if nums[mid] < nums[mid+ 1], 就往右边找
    int low = 0, high = nums.length - 1;
    while (low < high) {
      int mid = low + (high - low) / 2;
      // condition 就是low == high 也就是找到了peak 就会break;

      if (nums[mid] > nums[mid + 1]) { // 不是mid -1 当前high也要考虑进去
        high = mid;
      } else {
        low = mid + 1;
      }
    }
    return low;
  }
}
