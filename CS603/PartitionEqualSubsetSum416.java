package CS603;

public class PartitionEqualSubsetSum416 {
  public boolean canPartition(int[] nums) {
    int sum = 0;

    for (int num : nums) {
      sum += num;
    }

    if (sum % 2 != 0) {
      return false;
    }

    int target = sum / 2;

    int n = nums.length;
    boolean[] dp = new boolean[target + 1];
    dp[0] = true;

    for (int num : nums) {
      for (int currSum = target; currSum > 0; currSum--) {
        if (currSum - num >= 0) {
          dp[currSum] = dp[currSum] || dp[currSum - num];
        }
      }
    }

    return dp[target];
  }
}
