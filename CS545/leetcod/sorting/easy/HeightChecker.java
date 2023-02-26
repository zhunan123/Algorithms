package CS545.leetcod.sorting.easy;

import java.util.Arrays;

public class HeightChecker {
  /**
   * A school is trying to take an annual photo of all the students. The students are asked to stand in a single file line in non-decreasing order by height.
   * Let this ordering be represented by the integer array expected where expected[i] is the expected height of the ith student in line.
   * You are given an integer array heights representing the current order that the students are standing in.
   * Each heights[i] is the height of the ith student in line (0-indexed).
   * Return the number of indices where heights[i] != expected[i].
   *
   * Example 1:
   *
   * Input: heights = [1,1,4,2,1,3]
   * Output: 3
   * Explanation:
   * heights:  [1,1,4,2,1,3]
   * expected: [1,1,1,2,3,4]
   * */

  private static void merge(int[] arr, int[] temp, int low, int mid, int high) {
    int i = low;
    int j = mid + 1;
    int k = low;

    while (k <= high) {
      if (i > mid) {
        temp[k] = arr[j];
        j++;
      } else if (j > high) {
        temp[k] = arr[i];
        i++;
      } else {
        if (arr[i] < arr[j]) {
          temp[k] = arr[i];
          i++;
        } else {
          temp[k] = arr[j];
          j++;
        }
      }
      k++;
    }
    for (k = low; k <= high; k++){
      arr[k] = temp[k];
    }
  }
  private static void mergeSort(int[] heights, int[] temp, int low, int high) {
    if (high <= low) {
      return;
    }
    int mid = (low + high) / 2;
    mergeSort(heights, temp, low, mid);
    mergeSort(heights, temp, mid + 1, high);
    merge(heights, temp, low, mid, high);
  }
  public int heightChecker(int[] heights) {
    int[] heightsCopy = new int[heights.length];
    for (int i = 0; i< heights.length; i++) {
      heightsCopy[i] = heights[i];
    }
    int[] temp = new int[heights.length];
    int count = 0;
    mergeSort(heights, temp, 0, heights.length - 1);
    for (int i = 0; i < heights.length; i++) {
      if (heights[i] != heightsCopy[i]) {
        count++;
      }
    }
    System.out.println(count);
    return count;
  }

  public static void main(String[] args) {
    HeightChecker hc = new HeightChecker();
    int[] heights = {1,1,4,2,1,3};
    hc.heightChecker(heights);
    System.out.println(Arrays.toString(heights));
  }
}
