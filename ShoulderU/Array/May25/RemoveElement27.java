package ShoulderU.Array.May25;

public class RemoveElement27 {
    public int removeElement(int[] nums, int val) {
        // create current pointer
        int current = 0;

        // loop through the nums array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                // only advance pointer when current i not equal to val and update nums[current]
                nums[current] = nums[i];
                current++;
            }
            // in this case will remove all the value that equals value
            // when current i is equals to val, we just skip it, not updating current pointer and let loop automatically continue for pointer i and stop till we found value that is not val
        }
        return current;
    }
}
