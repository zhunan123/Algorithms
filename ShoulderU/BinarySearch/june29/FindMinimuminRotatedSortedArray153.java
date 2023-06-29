package ShoulderU.BinarySearch.june29;

public class FindMinimuminRotatedSortedArray153 {
    public int findMin(int[] nums) {
        // idea: if nums[mid] <= nums[high] [0,1,2,4,5,6,7], 说明left side from low to mid is ascending, then we know smallest on right side
        int low = 0, high = nums.length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= nums[high]) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return Math.min(nums[low], nums[high]);
    }
}
