package ShoulderU.backtrack.may29;

import java.util.ArrayList;
import java.util.List;

public class Subsets78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();

        backtrack(result, currList, 0, nums);
        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> currList, int current, int[] nums) {
        result.add(new ArrayList<>(currList));

        for (int i = current; i < nums.length; i++) {
            currList.add(nums[i]);
            backtrack(result, currList, i + 1, nums);
            currList.remove(currList.size() - 1);
        }
    }
}
