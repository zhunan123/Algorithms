package CS545.Week3;

import java.util.Arrays;
import java.util.Random;

public class QuickSortAdvanced {

  public static void swap(int ind1, int ind2, int[] arr) {
    int tmp = arr[ind1];
    arr[ind1] = arr[ind2];
    arr[ind2] = tmp;
  }

  private static int findMedian(int a, int b, int c) {
//    if ( (a - b) * (c - a) >= 0 ) // a >= b and a <= c OR a <= b and a >= c
//      return a;
//    else if ( (b - a) * (c - b) >= 0 ) // b >= a and b <= c OR b <= a and b >= c
//      return b;
//    else
//      return c;

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

  public static void quicksort(int[] arr, int low, int high) {
    int pivotIndex;
    if (low < high) {
      pivotIndex = partition(arr, low, high);
      quicksort(arr, low, pivotIndex - 1);
      quicksort(arr, pivotIndex + 1, high);
    }
  }

  public static int findRandomNumber(int low, int high) {
    return low + (int)(Math.random() * (high - low + 1));
  }

  private static int partition(int arr[], int low, int high) {
    int ramNum1 = findRandomNumber(low, high);
    int ramNum2 = findRandomNumber(low, high);
    int ramNum3 = findRandomNumber(low, high);

    int pivotIndex = findMedian(ramNum1, ramNum2, ramNum3);
    int pivotElement = arr[pivotIndex];

    swap(high, pivotIndex, arr);

    int i = low;
    int j = high - 1;
    while (i <= j) {
      while ((i <= j) && (arr[i] < pivotElement))
        i++;
      while ((i <= j) && (arr[j] >= pivotElement))
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

  public static void main(String[] args) {
    int[] arr = {5, 2, 9, 12, 6, 8, 3, 7};

    quicksort(arr, 1,6);
    System.out.println(Arrays.toString(arr));
  }
}
