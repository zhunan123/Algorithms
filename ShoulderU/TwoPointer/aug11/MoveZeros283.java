package ShoulderU.TwoPointer.aug11;

public class MoveZeros283 {
  public void moveZeroes(int[] nums) {
    // idea: have two pointer, have left pointer points to first element, right pointer points to 2nd elements.left pointter to find a zero, right pointer to find a non-zero, then swap them, then move both pointer by 1,

    //base case
    if (nums.length < 2) {
      return;
    }
    int left = 0, right = 1;
    while (right < nums.length) {
      while (left < right && nums[left] != 0){
        left++;
      }
      while (right < nums.length && nums[right] == 0) {
        right++;
      }
      if (left < right && right < nums.length) {
        swap(left, right, nums);
      }

      left++;
      right++;
    }
  }

  private void swap(int index1, int index2, int[] nums) {
    int temp = nums[index1];
    nums[index1] = nums[index2];
    nums[index2] = temp;
  }
}
