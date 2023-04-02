package ShoulderU.BinarySearch;

import java.util.Arrays;

public class SearchinRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

//        while (low <= high) {
//            int mid = low + (high - low) / 2;
//            if (nums[mid] == target) {
//                return true;
//            }
//            //either starts with nums[low] > nums[mid] or nums[mid] <= nums[low]
//            if (nums[mid] > nums[low]) { // condition 1 if low >= mid, then the ascending order in the right
//                if (target >= nums[low] && target <= nums[mid]) {
//                    high = mid - 1;
//                } else {
//                    low = mid + 1;
//                }
//            } else {
//                //condition 2 if mid >= left, then the ascending order in the left
//                if (target >= nums[mid] && target <= nums[high]) {
//                    low = mid + 1;
//                } else {
//                    high = mid -1;
//                }
//            }
//        }
        Arrays.sort(nums);
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid -1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchinRotatedSortedArrayII search1 = new SearchinRotatedSortedArrayII();
        int[] nums = {1,0,1,1,1};
        boolean res = search1.search(nums, 0);
        System.out.println(res);
    }
}
