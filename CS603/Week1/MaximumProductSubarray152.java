package CS603.Week1;

public class MaximumProductSubarray152 {
    /** Brute-Force */
    public int maxProduct(int[] nums) {
        //[-2, 0, 1]
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
                // if next is 0, product will always be 0, becasue it cumurative, 1 0 will cause product to be 0, best to write a break confition
                // add this break run time will decrease but space will increase
                //so need to think about it
                if (next == 0) {
                    break;
                }
                product *= next;
                if (product > max) {
                    max = product;
                }
            }
        }
        return max;
    }
}
