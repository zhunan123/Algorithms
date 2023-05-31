package ShoulderU.Array.May27;

public class BinarySearch704 {
    /**
     * normal binary searcg template, have left and right 2 pointer,
     * while left pointer <= right pointer, identify mid ppointer,
     * then 3 condition, when nums[mid] = or < or > target,
     * then increment left pointer or decrement right pointer accordingly.
     * */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
