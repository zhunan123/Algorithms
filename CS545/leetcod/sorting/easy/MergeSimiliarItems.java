package CS545.leetcod.sorting.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MergeSimiliarItems {

  /**
   * You are given two 2D integer arrays, items1 and items2, representing two sets of items. Each array items has the following properties:
   * items[i] = [valuei, weighti] where valuei represents the value and weighti represents the weight of the ith item.
   * The value of each item in items is unique.
   * Return a 2D integer array ret where ret[i] = [valuei, weighti], with weighti being the sum of weights of all items with value valuei.
   * Note: ret should be returned in ascending order by value.
   *
   *
   * Example 1:
   *
   * Input: items1 = [[1,1],[4,5],[3,8]], items2 = [[3,1],[1,5]]
   * Output: [[1,6],[3,9],[4,5]]
   * Explanation:
   * The item with value = 1 occurs in items1 with weight = 1 and in items2 with weight = 5, total weight = 1 + 5 = 6.
   * The item with value = 3 occurs in items1 with weight = 8 and in items2 with weight = 1, total weight = 8 + 1 = 9.
   * The item with value = 4 occurs in items1 wi
   * */

  class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
      //using tree map
      List<List<Integer>> result = new ArrayList<>();
      TreeMap<Integer, Integer> map = new TreeMap<>();

      for (var item : items1) {
        map.put(item[0], item[1]);
      }

      for (var item : items2) {
        map.putIfAbsent(item[0], 0);
        map.put(item[0], map.get(item[0]) + item[1]);
      }

      for (var item : map.keySet()) {
        List<Integer> list = new ArrayList<>();
        list.add(item);
        list.add(map.get(item));
        result.add(list);
      }

      return result;
    }
  }
}
