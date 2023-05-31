package ShoulderU.backtrack.may30;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NondecreasingSubsequences491 {
    /**
     * normal step, in the starting function define and within a hashset,
     * create a backtrack function, and inside the backtrack function,
     * define base condition if size >= 2 added into the ans set. and the recursive case,
     * write a for loop starting from the currentindex passed from starting function and until nums.length,
     * need to add a condition here, only if the currentList is empty || nums[i] >=currentList.getcurrentList.size() - 1)
     * since we want to only add the increasing integer
     * */
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();

        List<Integer> currentList = new ArrayList<>();
        backtrack(ans, currentList, nums, 0);
        return new ArrayList<>(ans);
    }

    public void backtrack(Set<List<Integer>> ans, List<Integer> currentList, int[] nums, int currentIndex) {
        if (currentList.size() >= 2) {
            ans.add(new ArrayList<>(currentList));
        }

        for (int i = currentIndex; i < nums.length; i++) {
            if (currentList.isEmpty() || (nums[i] >= currentList.get(currentList.size() - 1))) { // key of this algo is adding this condition
                // to make sure first pass and the condition when is equal or increasing
                // need to make sure this currentList.get(currentList.size() - 1) as well, since we need the nums[i - 1] might not be currentList.get
                // (currentList.size() - 1), but we need currentList.get(currentList.size() - 1) here.
                currentList.add(nums[i]);
                backtrack(ans, currentList, nums, i + 1);
                currentList.remove(currentList.size() - 1);
            }
        }
    }
}
