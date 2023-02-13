package CS545.Week3;

import java.util.Arrays;

public class QuickSortSolution2 {

  private static void swap(int ind1, int ind2, int[] arr) {
    int tmp = arr[ind1];
    arr[ind1] = arr[ind2];
    arr[ind2] = tmp;
  }

  public static void quickSort(int arr[], int low, int high) {
    int mid; //mid is usually the pivot index
    if (low < high) {
      mid = partition(arr, low, high); //mid is pivot index, smaller than pivot index is in the left, bigger than pivot index is on the right
      quickSort(arr, low, mid);
      quickSort(arr, mid + 1, high);
    }
  }

  private static int partition(int[] arr, int low, int high) {
    int pivotIndex = low;
    int i = low + 1;
    int j = high;

    while (i <= j) {
      while (i <= j && arr[i] <= arr[pivotIndex]){
        i++;
      }
      while (i <= j && arr[j] >= arr[pivotIndex]){
        j--;
      }
      if (i < j) {
        swap(i, j, arr);
      }
    }
    swap(pivotIndex, j, arr);
    return j;
  }


  public static void main(String[] args) {
    int[] arr = {6, 5, 8, 9, 3, 10};

    quickSort(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));
  }
}
