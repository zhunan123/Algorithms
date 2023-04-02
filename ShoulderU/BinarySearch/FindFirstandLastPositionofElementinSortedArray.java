package ShoulderU.BinarySearch;

import java.util.Arrays;

/**
 * using 2 steps, fist find the mid, if target > mid then we know
 * target on the right, if target < mid, then go left.
 * if mid=target, go to the left find first_pos, then update first_pos to mid
 * second step,same as previous, find mid, if mid = target,
 * go to the right and find last_pos
 * */

public class FindFirstandLastPositionofElementinSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int first_pos = -1;

        int res[]  = new int[]{-1, -1};

        //find first position
        //if mid == target, then we know the first start position is in the left
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                //if mid == target, then we know the first start position is in the left
                high = mid -1 ;
                first_pos = mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (first_pos == -1) {
            return res;
        } else {
            res[0] = first_pos;
        }

        low = 0;
        high = nums.length - 1;
        int last_pos = -1;
        //fine the last position
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                //if mid == target, then we know the last position is in the right, so we make low = mid + 1
                low = mid + 1;
                //update last position
                last_pos = mid;
            }else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (last_pos == -1) {
            return res;
        } else {
            res[1] = last_pos;
        }

        return res;
    }

    public static void main(String[] args) {
        FindFirstandLastPositionofElementinSortedArray bs = new FindFirstandLastPositionofElementinSortedArray();
        int[] nums = {5,7,7,8,8,10};
        int[] res = bs.searchRange(nums, 8);
        System.out.println(Arrays.toString(res));
    }
}
