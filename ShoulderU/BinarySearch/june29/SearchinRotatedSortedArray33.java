package ShoulderU.BinarySearch.june29;

public class SearchinRotatedSortedArray33 {
    public int search(int[] nums, int target) {

        // idea: 分两种情况，1.low <= mid 和low > mid, 然后把nums分两个part，search using BS search，in each condition first search the target in ascending part, then search the other part
        //只有两种情况，第一种nums[low] <= nums[mid] , 说明ascending part在low 到mid之间，就是在nums左侧, example 4,5,6,7,0,1,2, then first find the aascending part and search target in thie ascending part which is 4,5,6,7 and search other part
        //第二种nums[low] > nums[mid],, 说明ascending part在mid 到high之间，就是在nums右侧,， example 6,7,0,1,2,3,4,5 ,first search the ascending part which from 1,2,3,4,5, then search the other part
        // the target if in the ascending order part, and in the second part maybe have ascending and descending part

        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            // nums[low] <= nums[mid], 说明左边low - mid这一侧是ascending
            if (nums[low] <= nums[mid]) {
                // check if target in ascending part
                if (target >= nums[low] && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {// nums[low] > nums[mid], 说明ascending在 mid - high
                // check if target in ascending part
                if (target >= nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
