package ShoulderU.brute_force;

public class MaximumProductSubarray152 {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int product = nums[i];
            // if current number if greater then previous product like [1,2,8,3] first is 1 is greater than Integer.MIN_VALUE so update max
            max = Math.max(product, max);
            for (int j = i + 1; j < nums.length; j++) {
                int next = nums[j];
                product *= next;
                if (product > max) {
                    max = product;
                }
            }
        }
        return max;
    }
}
