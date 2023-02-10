package CS545.Week2;

import java.util.Arrays;

public class ShakeSort {

  public static void shakesort(int[] arr, int lowindex, int highindex, boolean reversed) {
    for (int i = 0; i < arr.length - 1; i++) {
      if (i >= lowindex && i < highindex) { //goes inverse order ---->
        boolean needSwap = false;
        if (!reversed) {
          for (int j = i + 1; j < highindex; j++) {
            if (arr[j] <= arr[j - 1]) {
              int temp = arr[j];
              arr[j] = arr[j - 1];
              arr[j - 1] = temp;
              needSwap = true;
            }
          }
          for (int j = highindex; j > i; j--) { //goes reverse order <-------
            if (arr[j] <= arr[j - 1]) {
              int temp = arr[j];
              arr[j] = arr[j - 1];
              arr[j - 1] = temp;
              needSwap = true;
            }
          }
        } else {
          for (int j = i + 1; j < highindex; j++) {
            if (arr[j] >= arr[j - 1]) {
              int temp = arr[j];
              arr[j] = arr[j - 1];
              arr[j - 1] = temp;
              needSwap = true;
            }
          }
          for (int j = highindex; j > i; j--) { //goes reverse order <-------
            if (arr[j] >= arr[j - 1]) {
              int temp = arr[j];
              arr[j] = arr[j - 1];
              arr[j - 1] = temp;
              needSwap = true;
            }
          }
        }
        if (!needSwap) { //the list is already sorted, so break the loop.
          break;
        }
      }
    }
  }



  public static void main(String[] args) {
    int[] arr = {4, 10, 6, 9, 2, 3, 8, 4};

    shakesort(arr, 1, 3, true);
    System.out.println(Arrays.toString(arr));
  }
}
