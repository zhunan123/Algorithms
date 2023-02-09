package CS545.Week2;

import java.util.Arrays;

public class ShakeSort {

  public static void shakesort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      boolean needSwap = false;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] <= arr[j - 1]) {
          int temp = arr[j];
          arr[j] = arr[j - 1];
          arr[j - 1] = temp;
          needSwap = true;
        }
      }
      for (int j = arr.length - 1; j > i; j--) {
        if (arr[j] <= arr[j - 1]) {
          int temp = arr[j];
          arr[j] = arr[j - 1];
          arr[j - 1] = temp;
          needSwap = true;
        }
      }
      if (!needSwap) {
        break;
      }
    }
  }



  public static void main(String[] args) {
    int[] arr = {4, 10, 6, 9, 2, 3, 8, 4};

    shakesort(arr);
    System.out.println(Arrays.toString(arr));
  }
}
