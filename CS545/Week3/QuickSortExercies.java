package CS545.Week3;

import java.util.Arrays;

public class QuickSortExercies {
    /**
     * Sorts the array that contains only 0s and 1s.
     * @param arr input array of integers
     */
  public static void sort01(int[] arr) {
    int i = 0;
    int j = arr.length - 1;
    // FILL IN CODE:
    // Repeat until i and j meet:
    // Move i to the right as long as we are looking at a 0
    // Move j to the left as long we are looking at a 1
    // swap elements at i and j


  }

  /**
   * Sorts the array of Strings that contains only "A" and "B"
   * @param votes array of strings, where each string is either "A" or "B".
   */
  public static void sortAB(String[] votes) {
    // FILL IN CODE (use the same algorithm as in sort01).


  }

  public static void main(String[] args) {
    int[] arr = {0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1};
    sort01(arr); // sort in ascending order
    System.out.println(Arrays.toString(arr));

        /*String[] votes = {"A", "B", "A", "A", "B", "A", "B", "B", "A"};
        sortAB(votes);
        System.out.println(Arrays.toString(votes));
         */
  }
}
