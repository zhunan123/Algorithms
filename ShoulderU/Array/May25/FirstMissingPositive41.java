package ShoulderU.Array.May25;

public class FirstMissingPositive41 {
    // help method check if nums contains a specific integer element
    public boolean isExist(int num, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                return true;
            }
        }
        return false;
    }
    public int firstMissingPositive(int[] nums) {

        // initilie table from 1 to nums.length
        int[] table = new int[nums.length];
        for (int i = 0; i < table.length; i++) {
            table[i] = i + 1;
        }


        // loop through table
        for (int i = 0; i < table.length; i++) {
            if (!isExist(table[i], nums)) {
                return table[i];
            }
        }
        return table.length + 1;
    }
}
