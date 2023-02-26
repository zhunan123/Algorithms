package CS545.leetcod.sorting.easy;

import java.util.Arrays;

public class SortIntegersbyTheNumberof1Bits {

  /**
   * You are given an integer array arr.
   * Sort the integers in the array in ascending order
   * by the number of 1's in their binary representation and in case of two or more
   * integers have the same number of 1's you have to sort them in ascending order.
   * Return the array after sorting it.
   *
   * Example 1:
   *
   * Input: arr = [0,1,2,3,4,5,6,7,8]
   * Output: [0,1,2,4,8,3,5,6,7]
   * Explantion: [0] is the only integer with 0 bits.
   * [1,2,4,8] all have 1 bit.
   * [3,5,6] have 2 bits.
   * [7] has 3 bits.
   * The sorted array by bits is [0,1,2,4,8,3,5,6,7]
   * */

  public static void sortInBits(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      arr[i] += Integer.bitCount(arr[i]) * 10001;
    }

    //insertion sort
    int curr;
    int j;
    for (int i = 1; i < arr.length; i++) {
      curr = arr[i];
      j = i - 1;
      while (j >= 0 && curr < arr[j]) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = curr;
    }
    System.out.println(Arrays.toString(arr));

    for (int i = 0; i < arr.length; i++) {
      /* using modulus here */
      arr[i] = (arr[i]) % 10001;
    }
  }

  public static void main(String[] args) {
    SortIntegersbyTheNumberof1Bits sort = new SortIntegersbyTheNumberof1Bits();
    int[] arr = {0,1,2,3,4,5,6,7,8};
    sort.sortInBits(arr);
    System.out.println(Arrays.toString(arr));
  }
}
