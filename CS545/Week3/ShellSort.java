package CS545.Week3;

import java.util.Arrays;

public class ShellSort {

  public static void shellSort(int[] array) {
    int gap;
    int n = array.length;
    for (gap = n / 2; gap > 0; gap /= 2) {
      for (int j = gap; j < n; j++) {
        for (int i = j - gap; i >= 0; i -= gap) {
          if (array[i + gap] > array[i]) {
            break;
          } else {
            int temp = array[i + gap];
            array[i + gap] = array[i];
            array[i] = temp;
          }
        }
      }
    }
  }




  public static void main(String[] args) {
    int[] arr = {5, 2, 9, 12, 6, 8, 3, 7};
    shellSort(arr);
    System.out.println(Arrays.toString(arr));
  }
}

