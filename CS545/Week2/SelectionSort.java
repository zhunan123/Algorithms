package CS545.Week2;

import java.util.Arrays;

public class SelectionSort {

  /**
   * not stable
   * running time depends on number of comparison
   * (n - 1) + (n - 2) + ....... + 2 + 1 = θ(n^2)
   * */

  public static void swap(int ind1, int ind2, int[] arr) {
    int tmp = arr[ind1];
    arr[ind1] = arr[ind2];
    arr[ind2] = tmp;
  }

  public static void selectionSort(int[] arr) {
    for (int i = 0; i < arr.length; i++){
      int min_index = i;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] < arr[min_index]) {
          min_index = j;
        }
      }
      swap(min_index, i, arr);
    }
  }

  public static void main(String[] args) {
    int[] arr = {7, 3, 6, 4, 1};
    System.out.println(Arrays.toString(arr));
    selectionSort(arr);
    System.out.println(Arrays.toString(arr));
  }
}
