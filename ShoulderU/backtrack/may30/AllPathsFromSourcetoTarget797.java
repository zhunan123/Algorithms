package ShoulderU.backtrack.may30;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourcetoTarget797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> currentList = new ArrayList<>();
        currentList.add(0);
        backtrack(ans, currentList, graph, 0);
        return ans;
    }

    public void backtrack(List<List<Integer>> ans, List<Integer> currentList, int[][] graph, int currVertex) {
        if (currVertex == graph.length - 1) {
            ans.add(new ArrayList<>(currentList));
            return;
        }

        for (int nextVertex : graph[currVertex]) { // this part is key, need to digest that from vertext 0 -> 1 -> 3 which these are next vertexx
            currentList.add(nextVertex);
            backtrack(ans, currentList, graph, nextVertex);
            currentList.remove(currentList.size() - 1);
        }
    }
}
