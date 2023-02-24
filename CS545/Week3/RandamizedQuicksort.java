package CS545.Week3;

import java.util.Arrays;

public class RandamizedQuicksort {
  public static void swap(int ind1, int ind2, int[] arr) {
    int tmp;
    tmp = arr[ind1];
    arr[ind1] = arr[ind2];
    arr[ind2] = tmp;
  }

  private static int findMedian(int a, int b, int c) {
    int[] arr =new int[3];
    arr[0] = a;
    arr[1] = b;
    arr[2] = c;

    if (arr[0] > arr[1]) {
      int temp = arr[1];
      arr[1] = arr[0];
      arr[0] = temp;
    }
    if (arr[1] > arr[2]) {
      int temp = arr[1];
      arr[2] = arr[1];
      arr[1] = temp;
    }
    if (arr[0] > arr[2]) {
      int temp = arr[2];
      arr[2] = arr[0];
      arr[0] = temp;
    }

    return arr[1];
  }

  private static int findRandomNumber(int low, int high) {
    return low + (int)(Math.random() * (high - low + 1));
  }

  private static int partition(int[] arr, int low, int high) {
    int pivotElement;

    int ramNum1 = findRandomNumber(low, high);
    int ramNum2 = findRandomNumber(low, high);
    int ramNum3 = findRandomNumber(low, high);

    int pivotIndex = findMedian(ramNum1, ramNum2, ramNum3);
    pivotElement = arr[pivotIndex];

    swap(high, pivotIndex, arr);

    int i = low;
    int j = high - 1;
    while (i <= j) {
      while ((i <= j) && (arr[i] < pivotElement))
        i++;
      while ((i <= j) && (arr[j]>= pivotElement))
        j--;
      if (i <= j) {
        swap(i, j, arr);
        i++;
        j--;
      }
    }
    swap(i, high, arr);
    return i;
  }

  /**
   * Sorts the sublist of the given list (from lowindex to highindex)
   * using the randomizedQuickSort
   * @param array array to sort
   * @param lowindex the beginning index of a sublist
   * @param highindex the end index of a sublist
   */
  public static void randomizedQuickSort(int[] array, int lowindex, int highindex) {
    // FILL ON CODE
    int pivotIndex;
    if (lowindex < highindex) {
      pivotIndex = partition(array, lowindex, highindex);
      randomizedQuickSort(array, lowindex, pivotIndex - 1);
      randomizedQuickSort(array, pivotIndex + 1, highindex);
    }
  }

  public static void main(String[] args) {
    int[] arr
            = { 24, 97, 40, 67, 88, 85, 15, 66, 53, 44, 26,
            48, 16, 52, 45, 23, 90, 18, 49, 80, 23 };

    randomizedQuickSort(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));
  }

}
