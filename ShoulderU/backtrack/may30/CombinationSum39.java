package ShoulderU.backtrack.may30;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum39 {

    /**
     * idea is when we find the sub array equals to target, add to result list, then return,
     * and if sum of list is greater than target then return as well. in recursive case add current integer to current list,
     * call backtrack function with current i since we can have muptiple current integer as much as possible.
     * finally backtracking and remove the last in the current list
     * */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();

        backtrack(result, currentList, candidates, target, 0);
        return result;
    }

    private int calculateSum(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    public void backtrack (List<List<Integer>> result, List<Integer> currentList, int[] candidates, int target, int currentIndex) {
        if (calculateSum(currentList) == target) {
            result.add(new ArrayList<>(currentList));
            return;
        } else if (calculateSum(currentList) > target) {
            return;
        }

        for (int i = currentIndex; i < candidates.length; i++) {
            currentList.add(candidates[i]);
            backtrack(result, currentList, candidates, target, i);
            currentList.remove(currentList.size() - 1);
        }
    }
}
