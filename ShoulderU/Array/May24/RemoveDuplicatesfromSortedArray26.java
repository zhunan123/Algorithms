package ShoulderU.Array.May24;

public class RemoveDuplicatesfromSortedArray26 {
    public int removeDuplicates(int[] nums) {
        int current = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[current]) { // continue until found distinct value
                current++;
                // update nums[count] will remove duplicates and add unique value
                nums[current] = nums[j];
            }
            // if duplicates we just skip
        }
        return current + 1;
    }
}
