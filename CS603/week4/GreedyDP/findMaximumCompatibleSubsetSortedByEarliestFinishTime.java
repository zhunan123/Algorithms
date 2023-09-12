package week4.GreedyDP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findMaximumCompatibleSubsetSortedByEarliestFinishTime {
    /**
     * sudo code
     * sort array by earliest finishing time
     * for i = 0 -> lists.len - 1, f1 <= f2 <= f3 <= f4......<=fn
     * S-> Ø, means initially s is empty set, Si = 4
     * if (j compatible with S, means Sj(current list start time) >= Fi(finish time of last one in sets)){
     *     S <- S ∪ {j} s is new sets with j added and update Fi = Fj
     * }
     * return S for result
     * */

    public static List<int[]> findMaximumCompatibleSet(int[][] lists) {
        Arrays.sort(lists, (a, b) -> a[1] - b[1]);
        List<int[]> ans = new ArrayList<>();
        ans.add(lists[0]);
        for (int i = 1; i < lists.length; i++) {
            if (lists[i][0] >= ans.get(ans.size() - 1)[1]) {
                ans.add(lists[i]);
            }
        }
        for (int[] list : ans) {
            System.out.println(Arrays.toString(list));
        }
        return ans;
    }

    // for this algorithms will the first always be added?

    public static void main(String[] args) {
        int[][] list = new int[][] {{0, 6}, {1,4}, {3, 5}, {3, 8}, {4, 7}, {5, 9}, {6, 10}, {8,11}};
        findMaximumCompatibleSet(list);
    }
}
