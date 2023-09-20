package DP;

public class HouseRobber198 {
    public int rob(int[] nums) {
        // 1 dimentional DP,
        /**
         def: find max money that can steal given a number of n houses , same as find max number of subset given n intervals
         checkout the notes
         */

        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i + 1] = Math.max(nums[i] + dp[i - 1], dp[i]);
        }
        return dp[nums.length];
    }
}
