package ShoulderU.BinarySearch;

public class MinimumSizeSubarraySum {

    /**
     * will have 2 pointer, right pointer will expand the window,
     * left pointer will subtract the  window.
     * if satify the condition subtractthe window,
     * if do not satify the condition we expand the window
     *
     * have 2 pointers, another 1 for sum, one for min_subarray_length,
     * if not meet the condition means we havent find the
     * sub array whcih sum adds up to 7,
     * we continue move right pointer to add sum.
     * once we find it, update the min_subarray,
     * then move left pointer to subtracts sum,
     * after subtract the sum, if not meet the condition again,
     * then need to expand the window by moveing the right
     * forward
     * */

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int min_subarray_len = Integer.MAX_VALUE;
        int sum = 0;

        while (right < nums.length) {
            //add current to sum expand the window
            sum += nums[right];
            //if meet condition then subtract the window using while
            while (sum >= target) {
                min_subarray_len = Math.min(min_subarray_len, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }

        if (min_subarray_len == Integer.MAX_VALUE) {
            return 0;
        } else {
            return min_subarray_len;
        }
    }
}
