package CS545.Week3;

import java.util.Arrays;

public class HybridSort {

  private static void swap(int ind1, int ind2, int[] arr) {
    int tmp = arr[ind1];
    arr[ind1] = arr[ind2];
    arr[ind2] = tmp;
  }

  private static void insertionSort(int[] arr, int lowindex, int highindex) {
    int j;
    int cur;
    for (int i = 0; i < arr.length; i++) {
      if (i >= lowindex && i < highindex) {
        cur = arr[i + 1];
        j = i;
        while (j >= lowindex && cur < arr[j]) {
          arr[j + 1] = arr[j];
          j--;
        }
        arr[j + 1] = cur;
      }
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
  public static void hybridQuickSort(int arr[], int low, int high) {
    while (low < high) {
      if (high - low < 10) {
        insertionSort(arr, low, high);
        break;
      }
      else {
        int pivot = partition(arr, low, high);
        if (pivot - low < pivot - high) {
          hybridQuickSort(arr, low, pivot - 1);
          low = pivot + 1;
        }
        else {
          hybridQuickSort(arr, pivot + 1, high);
          high = pivot - 1;
        }
      }
    }
  }
  public static void main(String[] args) {
    int arr[]
            = { 24, 97, 40, 67, 88, 85, 15, 66, 53, 44, 26,
            48, 16, 52, 45, 23, 90, 18, 49, 80, 23 };

    hybridQuickSort(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));
  }
}
