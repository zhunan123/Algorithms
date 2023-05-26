package ShoulderU.Array.May25;

public class SubarraySumEqualsK560 {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int currSum = nums[i];
            // check the currSum if already equals k
            if (currSum == k) {
                count++;
            }
            // define pointer
            int j = i + 1;
            while (j < nums.length) {
                currSum = currSum + nums[j];
                if (currSum == k) {
                    count++;
                }
                j++;
            }
        }
        return count;
    }
}
