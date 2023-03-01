package CS545.week5;

import java.util.Arrays;

public class RadixSort {

  /** Radix Sort. Assume the number of digits in each key is the same.  */
  public static void radixSort(Elem[] arr) {
    // First, compute the number of digits in each key
    // Since we assume they all have the same # of digits,
    // it's enough to compute the # of digits in the first key
    if (arr.length == 0)
      return;
    int ndigits = (int) (Math.log10(arr[0].getKey()) + 1);

    Elem[] temp = new Elem[arr.length];

    int[] count = new int[10]; // count array for counting sort
    for (int i = 0, place = 1; i < ndigits; i++, place *= 10) {
      // place will be 1, then 10, then 100, then 1000, etc.
      // initialize count array
      for (int j = 0; j < 10; j++)
        count[j] = 0;
      // iterate over arr and fill out the count array
      for (int j = 0; j < arr.length; j++) {
        int k = (arr[j].getKey() / place) % 10;
        count[k]++;
      }

      for (int j = 1; j < 10; j++) // modified count array
        count[j] += count[j - 1];

      // result will be in temp
      for (int j = arr.length - 1; j >= 0; j--) {
        count[(arr[j].getKey() / place) % 10]--;
        int index = count[(arr[j].getKey() / place) % 10];
        temp[index] = arr[j];
      }

      // copy the result back into arr
      for (int j = 0; j < arr.length; j++)
        arr[j] = temp[j];
    }
  }

  public static void main(String[] args) {
    Elem[] elements = {
            new Elem(456, "A"), new Elem(308, "B"),
            new Elem(207, "C"), new Elem(405, "D"),
            new Elem(301, "E"), new Elem(123, "F"),
            new Elem(198, "E"), new Elem(883, "F"),

    };
    radixSort(elements);
    System.out.println(Arrays.toString(elements));
  }
}
