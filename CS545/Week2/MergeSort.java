package CS545.Week2;

import java.util.Arrays;

public class MergeSort {
  //recursive
  //merge function is not recursive， will take 2 subarray and combine into 1 sorted array
  //θ(n*logn)
  /**
   * time complexity:
   * T(1) = time to solve problem of size 1--->base case
   * T(n) = time required to solve a problem of size n
   * T(1) = c1
   * T(n) = 2T(n/2) +c2*n plug n/2 into T(n)
   * T(n) = 2T(n/2) +c2*n = 2(2T(n/4) +c2*(n/2) + c2*n = 4T(n/4) +2*c2*n = 2^k*T(n/(2^k)) +k*n*c2
   * because T(1) = c1 ----->n/(2^k) = 1, n = 2^k, k= log(n)
   * T(n) = 2^log(n)*T(n/2^log(n)) + log(n)*n*c2 = n*T(1) +n*log(n)*c2
   * θ(n*log(n))
   * */





  /**STEP 1
   * Merge two sorted arrays into one sorted array
   *
   * @param arr1 sorted array 1
   * @param arr2 sorted array 2
   * @return  sorted array that has elements from arr1 and arr2
   */
  public static int[] merge(int[] arr1, int[] arr2) {
    int[] result = new int[arr1.length + arr2.length];
    // FILL IN CODE
    // initialize i, j, k
    // Repeat:
    // compare elements arr[i] and arr[j], and depending on
    // which one is smaller, place the element in result at index k,
    // and increment either i or j
    // Increment k

    int i = 0;
    int j = 0;
    int k = 0;
    while (k < arr1.length + arr2.length) {
      if (i >= arr1.length) {
        result[k] = arr2[j];
        j++;
      } else if (j >= arr2.length) {
        result[k] = arr1[i];
        i++;
      } else {
        if (arr1[i] < arr2[j]) {
          result[k] = arr1[i];
          i++;
        } else {
          result[k] = arr2[j];
          j++;
        }
      }
      k++;
    }
    return result;
  }




  /**STEP 2
   * Merge two sorted sublists together, one that goes from low to mid another
   * goes from mid+1 to high. Uses a temporary array.
   * Merge two sorted subarrays: the one that starts at index low and ends at mid=(low+high)/2,
   * and the other that starts at mid+1 and ends at high (inclusive)
   *
   * @param arr - array
   * @param temp - temporary array - "scratch paper" (needed for merging two sorted chunks)
   * @param low - first index of the first sorted chunk of the array
   * @param mid - the last index of the first sorted chunk
   * @param high - the last index of the second sorted chunk
   */
  public static void merge(int[] arr, int[] temp, int low, int mid, int high) {
    // FILL IN CODE
    // find mid
    // initialize i, j, k
    // while k <= high
    // compare elements and merge
    //merge({1, 5, 2, 8}, 0, 1, 3 )

    int i = low;
    int j = mid + 1;
    int k = low;

    while (k <= high) {
      if (i > mid) {
        temp[k] = arr[j];
        j++;
      } else if (j > high) {
        temp[k] = arr[i];
        i++;
      } else {
        if (arr[i] < arr[j]) {
          temp[k] = arr[i];
          i++;
        } else {
          temp[k] = arr[j];
          j++;
        }
      }
      k++;
    }
    for (k = low; k <= high; k++){
      arr[k] = temp[k];
    }
//    System.out.println(Arrays.toString(arr));
  }




  /** public method for mergeSort - called from outside the class */
  public static void mergeSort(int[] arr) {
    int[] temp = new int[arr.length];
    mergeSort(arr, temp, 0, arr.length - 1);
  }



  /**STEP3
   * A private mergeSort method - takes an array, a temporary array, and the
   * indices that specify what part of the list we are working with (we need
   * to sort the part from low to high)
   *
   * @param arr
   * @param temp
   * @param low
   * @param high
   */
  private static void mergeSort(int[] arr, int[] temp, int low, int high) {
    if (low >= high){
      return;
    }
    int mid = (low + high) / 2;
    mergeSort(arr, temp, low, mid);
    mergeSort(arr, temp, mid + 1, high); // merge two sorted halves into one
    merge(arr, temp, low, mid, high);
  }



  public static void main(String[] args) {
    int[] arr1 = {1, 6, 8, 10, 100, 215};
    int[] arr2 = {2, 4, 9, 14};
    int[] arr = {1, 5, 2, 8};
    int[] arr3 = {7, 3, 1, 6, 4, 5, 2};
    System.out.println(Arrays.toString(arr1));
    System.out.println(Arrays.toString(arr2));
//    int[] result = merge(arr1, arr2);
//    System.out.println(Arrays.toString(result));

//    int[] temp = new int[arr.length];
//    merge(arr, temp, 0, 1, 3);

    mergeSort(arr3);
    System.out.println(Arrays.toString(arr3));
  }
}
