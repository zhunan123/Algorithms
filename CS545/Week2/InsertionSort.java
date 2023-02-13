package CS545.Week2;

import java.util.Arrays;

public class InsertionSort {
  /**
   * Worst case reverse sorted list θ(n^2),(n - 1) + (n - 2) + ....... + 2 + 1 = θ(n^2)
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

  public static void insertionSort2(int[] arr, int lowindex, int highindex, boolean reversed) {
    int j;
    int cur;
    for (int i = 0; i < arr.length; i++) {
      if (i >= lowindex && i < highindex) {
        cur = arr[i + 1];
        j = i;
        if (!reversed) {
          while (j >= lowindex && cur < arr[j]) {
            arr[j + 1] = arr[j];
            j--;
          }
        } else {
          while (j >= lowindex && cur > arr[j]) {
            arr[j + 1] = arr[j];
            j--;
          }
        }
        arr[j + 1] = cur;
      }
    }
  }

  public static void main(String[] args) {
    int[] arr = {8, 7, 2, 7, 15, 4, 6, 9, 5};
//    System.out.println(Arrays.toString(arr));
//    insertionSort(arr);
//    System.out.println(Arrays.toString(arr));

    insertionSort2(arr,2,6, true);
    System.out.println(Arrays.toString(arr));
  }
}
