package CS545.Week2;

import java.util.Arrays;

public class BubbleSort {

  /**
   * bubble sort is stable
   * running time depends on number of comparison
   * (n - 1) + (n - 2) + (n - 3) + ....... + 2 + 1 = θ(n^2)
   * */

  public static void swap(int ind1, int ind2, int[] arr) {
    int tmp = arr[ind1];
    arr[ind1] = arr[ind2];
    arr[ind2] = tmp;
  }
  public static void bubbleSort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      // start at the end and go to i/pos,
      // bubble the smallest element to the top
      for (int j = arr.length - 1; j > i; j--) {
        if (arr[j] < arr[j - 1]){
          swap(j, j - 1, arr);
        }
      }
    }
  }

  public static void main(String[] args) {
    int[] arr = {7, 3, 6, 4, 1};
    System.out.println(Arrays.toString(arr));
    bubbleSort(arr);
    System.out.println(Arrays.toString(arr));
  }
}
