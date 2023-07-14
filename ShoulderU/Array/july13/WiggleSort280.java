package ShoulderU.Array.july13;

public class WiggleSort280 {
    public void wiggleSort(int[] nums) {
        // odd index is greater than the even index, nums[odd] must > nums[odd + 1] nums[even] nust < nums[even + 1] otherwise need to swap to make it wiggle
        // if is odd number if nums[odd] < nums[odd + 1] so swap
        // if is even number if nums[even] > nums[even + 1] so swap

        for (int i = 0; i < nums.length - 1; i++) {
            if (i % 2 == 0) {
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            } else {
                if (nums[i] < nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            }
        }
    }

    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
