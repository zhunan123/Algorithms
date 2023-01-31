package CS545.Week2;

import java.util.Arrays;

public class InsertionSort {
  /**
   * Worst case inverse sorted list θ(n^2),
   * Best case  sorted list θ(n)
   * Average θ(n^2)
   * */

  public static void insertionSort(int[] arr) {
    int curr;
    int j;
    for (int i = 1; i < arr.length; i++) {
      curr = arr[i]; // insert curr into the sorted part of the list
      j = i - 1;  // last element in the sorted part
      while ((j >=0) && (curr < arr[j])) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = curr;
    }

  }

  public static void main(String[] args) {
    int[] arr = {7, 3, 6, 4, 1};
    System.out.println(Arrays.toString(arr));
    insertionSort(arr);
    System.out.println(Arrays.toString(arr));
  }
}
