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
    while (i < j) {
      while (i < j && arr[i] == 0) {
        i++;
      }
      while (i < j && arr[j] == 1) {
        j--;
      }
      if (i < j) {
        arr[i] = 0;
        arr[j] = 1;
      }
    }
  }

  /**
   * Sorts the array of Strings that contains only "A" and "B"
   * @param votes array of strings, where each string is either "A" or "B".
   */
  public static void sortAB(String[] votes) {
    // FILL IN CODE (use the same algorithm as in sort01).
    int i = 0;
    int j = votes.length - 1;

    while (i < j) {
      while (i < j && votes[i].compareTo("A") == 0) {
        i++;
      }
      while (i < j && votes[j].compareTo("B") ==0) {
        j--;
      }
      if (i < j) {
        votes[i] = "A";
        votes[j] = "B";
      }
    }
  }

  public static void swap(int i, int j, int[] arr) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static int partition(int low, int high, int[] arr) {
    int pivotElement;
    int pivotIndex = (low + high) / 2;
    pivotElement = arr[pivotIndex];
    swap(pivotIndex, high, arr);

    int i = low;
    int j = high - 1;

    while (i <= j) {
      while (i <= j && (arr[i] < pivotElement)) {
        i++;
      }
      while (i <= j && (arr[j] >= pivotElement)) {
        j--;
      }

      if (i < j) {
        swap(i, j, arr);
        i++;
        j--;
      }
    }
    swap(i, high, arr);
    return i; // this is return index
  }

  public static void main(String[] args) {
//    int[] arr = {0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1};
//    sort01(arr); // sort in ascending order
//    System.out.println(Arrays.toString(arr));

//      String[] votes = {"A", "B", "A", "A", "B", "A", "B", "B", "A"};
//      sortAB(votes);
//      System.out.println(Arrays.toString(votes));
//
    int[] arr = {8, 5, 9, 1, 6, 0, 9, 13, 4, 10};
    int i = partition(0, arr.length - 1, arr);
    System.out.println(i);
    System.out.println(Arrays.toString(arr));
  }
}
