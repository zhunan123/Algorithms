package CS545.leetcod.sorting.easy;

import java.util.Arrays;

public class DeleteGreatestValue {
  /**
   * You are given an m x n matrix grid consisting of positive integers.
   * Perform the following operation until grid becomes empty:
   * Delete the element with the greatest value from each row. If multiple such elements exist, delete any of them.
   * Add the maximum of deleted elements to the answer.
   * Note that the number of columns decreases by one after each operation.
   * Return the answer after performing the operations described above.
   *
   * Example 1:
   *
   * Input: grid = [[1,2,4],[3,3,1]]
   * Output: 8
   * Explanation: The diagram above shows the removed values in each step.
   * - In the first operation, we remove 4 from the first row and 3 from the second row (notice that, there are two cells with
   *    value 3, and we can remove any of them). We add 4 to the answer.
   * - In the second operation, we remove 2 from the first row and 3 from the second row. We add 3 to the answer.
   * - In the third operation, we remove 1 from the first row and 1 from the second row. We add 1 to the answer.
   * The final answer = 4 + 3 + 1 = 8.
   * */

  public static void sort(int grid[]){
    for (int i = 0; i < grid.length - 1; i++) {
      for (int j = grid.length - 1;  j > i; j--) {
        if (grid[j] < grid[j - 1]){
          int temp = grid[j];
          grid[j] = grid[j - 1];
          grid[j - 1] = temp;
        }
      }
    }
  }

  public static int deleteGreatestValue(int[][] grid) {
    int res = 0;
    for (int z = 0; z < grid.length; z++){
      sort(grid[z]);
    }
    int l = grid[0].length;
    while (l > 0) {
      int max = 0;
      for (int n = 0; n < grid.length; n++) {
        max = Math.max(max, grid[n][l - 1]);
      }
      res += max;
      l--;
    }

    System.out.println(res);
    return res;
  }

  public static void main(String[] args) {
    int[] arr1 = {1, 2, 4};
    int[] arr2 = {3, 3, 1};
    int[][] grid = new int[3][3];
    grid[0] = arr1;
    grid[1] = arr2;

    deleteGreatestValue(grid);
  }
}
