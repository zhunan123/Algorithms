package ShoulderU.Array.May26;

public class LeftandRightSumDifferences2574 {
    public int[] leftRightDifference(int[] nums) {
        // create ans array
        int[] ans = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            int leftSum = 0;
            int rightSum = 0;

            // count leftSum
            for (int j = i - 1; j >= 0; j--) {
                leftSum += nums[j];
            }
            // count rightSum
            for (int z = i + 1; z < nums.length; z++) {
                rightSum += nums[z];
            }

            // calculate the leftRight sum diff
            int diff = Math.abs(rightSum - leftSum);
            ans[i] = diff;
        }

        return ans;
    }
}
