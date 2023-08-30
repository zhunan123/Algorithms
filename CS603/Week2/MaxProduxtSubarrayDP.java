package CS603.Week2;

public class MaxProduxtSubarrayDP {
  public static int maxProduct(int[] nums) {
    // can take up to 2 comparisons and 1 assignment
    //worst case nums == null is false and nums.length == 0 is true, then do return 0, so worst call 2 comparisons and 1 assignemnts
    if (nums == null || nums.length == 0) {
      return 0;
    }

    // Total: 3 assn + (n-1) assign + (5 comparisons + 3 assignment) * (n - 1) + 1 calling method cost
    // assignment = c_a, comparisons: c_c, method cost = c_m
    // (3 + (n - 1) + 3(n-1)) * c_a + 5(n-1) * c_c + c_m
    // linear growth = O(n)
    //O(logn), O(n), O(nlogn), O(n^k), O(k^n)

    // 3 assignments
    int maxProduct = nums[0];
    int minProduct = nums[0];
    int result = nums[0];
    //n = nums.length, and (n - 1) assignment for i
    // (5 comparisons + 3 assignment) * (n - 1)
    for (int i = 1; i < nums.length; i++) {
      // 1 assignment
      int temp = maxProduct;
      //2 comparisons + 1 assignment
      maxProduct = Math.max(Math.max(nums[i], maxProduct * nums[i]), minProduct * nums[i]);
      //2 comparisons + 1 assignment
      minProduct = Math.min(Math.min(nums[i], temp * nums[i]), minProduct * nums[i]);
      //1 comparison
      result = Math.max(maxProduct, result);
    }

    // 1 return (calling method cost)
    return result;
  }
}
