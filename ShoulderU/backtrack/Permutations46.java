package ShoulderU.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations46 {
    public List<List<Integer>> permute(int[] nums) {
        // create ans list
        List<List<Integer>> ans = new ArrayList<>();

        // create a list
        List<Integer> list = new ArrayList<>();

        // convert int[] nums into arraylist easier for the collections.swap()
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }

        //defind backtrack function
        backtrack(ans, list, 0);

        // return ans
        return ans;
    }

    public void backtrack(List<List<Integer>> ans, List<Integer> nums, int first) {
        // base case
        if (first == nums.size()){
            ans.add(new ArrayList<>(nums));
        }

        // recursive case
        for (int i = first; i < nums.size(); i++) {
            Collections.swap(nums, i, first); // place i-th integer first in the current permutation
            backtrack(ans, nums, first + 1); // use next integers to complete the permutations
            Collections.swap(nums, i, first); // backtrack
        }
    }
}
