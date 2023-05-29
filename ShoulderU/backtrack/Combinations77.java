package ShoulderU.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Combinations77 {
    // create ans list
    List<List<Integer>> ans = new ArrayList<>();

    // create current inner list
    List<Integer> list = new ArrayList<>();


    public List<List<Integer>> combine(int n, int k) {

        // call backtrack function
        backtrack(1, n, k);
        // return ans
        return ans;
    }

    public void backtrack(int currIndex, int n, int k) {
        // base case
        if (list.size() == k) { // find the answer
            ans.add(new ArrayList<>(list));
            return;
        }

        // revursive case
        for(int i = currIndex; i <= n; i++) {
            list.add(i); // add current integer
            backtrack(i + 1, n, k); // move to next integer
            list.remove(list.size() - 1); // remove the last integer before start backtrack
        }
        // when we done with for loop is when we start back track
    }
}
