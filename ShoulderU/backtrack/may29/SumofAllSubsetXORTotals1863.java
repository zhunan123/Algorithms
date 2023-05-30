package ShoulderU.backtrack.may29;

import java.util.ArrayList;
import java.util.List;

public class SumofAllSubsetXORTotals1863 {
    int sum = 0;

    public int subsetXORSum(int[] nums) {
        List<Integer> currList = new ArrayList<>();
        backtrack(nums, currList, 0);
        return sum;
    }

    public int calculateXOR(List<Integer> list) {
        int result = 0;
        for (int num : list) {
            result ^= num;
        }
        return result;
    }

    public void backtrack(int[] nums, List<Integer> currList, int current) {
        sum += calculateXOR(currList);

        for (int i = current; i < nums.length; i++) {
            currList.add(nums[i]);

            backtrack(nums, currList, i + 1);

            currList.remove(currList.size() - 1);
        }
    }
}
