package week4.GreedyDP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findMaximumCompatibleSubsetSortedByLatestStartingTime {

    public static void main(String[] args) {
        int[][] list = new int[][] {{0, 6}, {1,4}, {3, 5}, {3, 8}, {4, 7}, {5, 9}, {6, 10}, {8,11}};
        findMaximumCompatibleSet(list);
    }

    /**
     * sudo code
     * sort lists by latest starting time
     * initial s <- Ø,initially s is empty set, add Si = 8
     * for i = 1 -> list.len - 1 S1 >= s2 >= s3 >= s4..... >= sn
     * if (sj compatible with S means Si >= fj(fj is the finish time of last element in set)){
     *     s <- s ∪ {j}  add j to S
     * }
     * return s
     * */

    private static List<int[]> findMaximumCompatibleSet(int[][] lists) {
        Arrays.sort(lists, (a, b) -> b[0] - a[0]);
        List<int[]> ans = new ArrayList<>();
        ans.add(lists[0]);
        for (int i = 1; i < lists.length; i++) {
            if (lists[i][1] <= ans.get(ans.size() - 1)[0]) {
                ans.add(lists[i]);
            }
        }
        for (int[] list : ans) {
            System.out.println(Arrays.toString(list));
        }
        return ans;
    }
}
