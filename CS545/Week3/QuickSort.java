package CS545.Week3;

import java.util.Arrays;

public class QuickSort {

  /**
   * worest case break list into size n-1 and 0 theta(n^2)
   * best case break list n/2 theta(nlogn)
   * */

  public static void swap(int ind1, int ind2, int[] arr) {
    int tmp = arr[ind1];
    arr[ind1] = arr[ind2];
    arr[ind2] = tmp;
  }

  public static void quickSort(int arr[]) {
    quickSort(arr, 0, arr.length - 1);
  }

  private static void quickSort(int arr[], int low, int high) {
    int pivotIndex;
    if (low < high) {
      pivotIndex = partition(arr, low, high);
      quickSort(arr, low, pivotIndex - 1);
      quickSort(arr, pivotIndex + 1, high);
    }
  }

  private static int partition(int arr[], int low, int high) {
    int pivotIndex = (low + high) / 2;
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
    int[] arr = {6, 5, 8, 9, 3, 10};

    quickSort(arr);
    System.out.println(Arrays.toString(arr));
  }
}
