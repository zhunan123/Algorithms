package CS545.leetcod.sorting.easy;

import java.util.HashMap;

public class SortThePeople {

  /**
   * You are given an array of strings names, and an array heights that consists of distinct positive integers. Both arrays are of length n.
   * For each index i, names[i] and heights[i] denote the name and height of the ith person.
   * Return names sorted in descending order by the people's heights.
   *
   * Example 1:
   *
   * Input: names = ["Mary","John","Emma"], heights = [180,165,170]
   * Output: ["Mary","Emma","John"]
   * Explanation: Mary is the tallest, followed by Emma and John.
   * */

  public static String[] sortPeople(String[] names, int[] heights) {
    HashMap<Integer, String> map = new HashMap<Integer, String>();

    for (int i = 0; i < names.length; i++) {
      map.put(heights[i], names[i]);
    }


    for (int i = 0; i < heights.length - 1; i++) {
      for (int j = heights.length - 1; j > i; j--) {
        if (heights[j] < heights[j - 1]){
          int tmp = heights[j];
          heights[j] = heights[j - 1];
          heights[j - 1] = tmp;
        }
      }
    }

    String[] res = new String[heights.length];
    int index = 0;
    for (int j = heights.length - 1; j >=0; j--) {
      res[index] = map.get(heights[j]);
      index++;
    }

    return res;
  }

  public static void main(String[] args) {
    String[] names = {"Mary","John","Emma"};
    int[] heights = {180,165,170};

    sortPeople(names, heights);
  }
}
