package ShoulderU.BinarySearch;

public class SearchInRotatedSortedArray {
    /**
     * There is an integer array nums sorted in ascending order (with distinct values).
     *
     * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
     *
     * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
     *
     * You must write an algorithm with O(log n) runtime complexity.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [4,5,6,7,0,1,2], target = 0
     * Output: 4
     * Example 2:
     *
     * Input: nums = [4,5,6,7,0,1,2], target = 3
     * Output: -1
     * Example 3:
     *
     * Input: nums = [1], target = 0
     * Output: -1
     * */


    /**
     * 33. Search in Rotated Sorted Array
     * Compare the left most number(low) with mid,
     * if low smaller than mid, then we know the ascending order from left to mid.,
     * then we find if the number in the left range. then make high = mid - 1,
     * if the number is not in left range, then we know the range is in the right,
     * then low is mid + 1
     * */

    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) { // nned low <= high since need [1] target = 1 case, low + 1 < high will not pass
            int mid = low + (high - low) / 2;
            if (nums[mid] == target){
                return mid;
            }

            //case 1 if nums[low <= nums[mid]   4,5,6,7,0,1,2, mid is 7, before 7 is ascending
            if (nums[low] <= nums[mid]) {
                //case 1 if target is left side range
                if (target >= nums[low] && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    //case 2 if target in not in the left range, then its in the right range
                    low = mid + 1;
                }
            } else {
                //case 2 nums[low] >= nums[mid]  6,7,0,1,2,3,4,5  mid is 1, after 1 is ascending
                if (target >= nums[mid] && target <= nums[high]) { //case 1 if target in the right side range
                    low = mid + 1;
                } else { //case 2 if number in the left range
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
