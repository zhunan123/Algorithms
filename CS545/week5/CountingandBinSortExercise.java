package CS545.week5;
import CS545.week5.Elem;

import java.util.Arrays;
import java.util.LinkedList;

public class CountingandBinSortExercise {

  public static class CountingAndBinSortExercises {
    /**
     * @param arr input array
     * Assume the range of elements  in the array is from 0 to maxValue
     * @param maxValue the largest value that we can have in the array
     * Note: this is not how the counting sort is typically implemented!
     */

    /*
    * int[] arr = {6, 9, 1, 5, 9, 0, 1, 9, 6, 4};
    * 0 1 2 3 4 5 6 7 8 9
    * --------------------
    * 1 2 0 0 1 1 2 0 0 3  //counter array
    * --------------------
    * 0 1 1 4 5 6 6 9 9 9
    * */
    public static void basicCountingSort(int[] arr, int maxValue) {
      int[] counterArray = new int[maxValue + 1];
      // Iterate over arr, and for each val = arr[i], increment counterArray[val].
      // FILL IN CODE
      for (int i = 0; i < arr.length; i++) {
        counterArray[arr[i]]++;
      }


      // Iterate over the counter array, and use it to sort arr
      // FILL IN CODE
      int count = 0;
      for (int k = 0; k < counterArray.length; k++) {
        // write a loop that adds k to arr num=counterArray[k] times
        // FILL IN CODE
        int freq = counterArray[k];
        for (int j = 0; j < freq; j++) {
          arr[count] = k;
          count++;
        }
      }
    }

    /**
     * Bin sort
     * @param arr array of elements, where each element has an integer key >= 0
     * @param maxValue largest value of any key in the array
     */
    //similiar to counting sort, have advantage when have very small integer range
    public static void binSort(Elem[] arr, int maxValue) {
      int i = 0;
      LinkedList<Elem>[] bins = new LinkedList[maxValue+1];
      // Initialize all the linked lists
      for (i = 0; i <= maxValue; i++)
        bins[i] = new LinkedList<>();

      // Iterate over arr; get the key of each element
      // and place the element in the corresponding bin:
      // the index of the bin is equal to the key
      for (i = 0; i < arr.length; i++) {
        // FILL IN CODE

      }

      // Iterate over the bins and place elements back into arr
      int count  = 0;
      for (int k = 0; k <= maxValue; k++) {
        LinkedList<Elem> list  = bins[k];
        // FILL IN CODE: iterate over this bin and place elements back into arr

      }
    }

    public static void main(String[] args) {
      int[] arr = {6, 9, 1, 5, 9, 0, 1, 9, 6, 4};
      basicCountingSort(arr, 10);
      System.out.println(Arrays.toString(arr));

        /*
        // Uncomment for testing the bin sort
        Elem[] elements = {
                new Elem(4, "A"), new Elem(0, "B"),
                new Elem(2, "C"), new Elem(4, "D"),
                new Elem(0, "E"), new Elem(1, "F")
        };
        binSort(elements, 10);
        System.out.println(Arrays.toString(elements));
        */
    }

  }
}
