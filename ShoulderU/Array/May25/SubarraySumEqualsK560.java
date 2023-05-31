package ShoulderU.Array.May25;

public class SubarraySumEqualsK560 {
    /**
     * brutel method iterate the hard way. have a outter for loop to keep track starting position from i to nums.length
     * then define the current sum, have another pointer j start from the i + 1;while j < nums.length,
     * update the current sum with adding the current nums[j], if currentSum == k, increment count.
     * advance pointer j. finally return count;
     * */
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
