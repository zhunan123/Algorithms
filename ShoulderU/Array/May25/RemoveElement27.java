package ShoulderU.Array.May25;

public class RemoveElement27 {
    /**
     * similiar idea as above question, have a current pointer to 0;
     * loop the nums array from position pointer i from 0, if nums[i] != val,
     * means we can update to nums array current pointer to i pointer in nums array,
     * then advanced current point. else means current i is equals to val, we just skip it,
     * not updating current pointer and let loop automatically continue for pointer i and stop till we found value that is not val.
     * finally return current pointer. [3, 2, 2, 3] val = 3 ----> [2,2]
     * */
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
