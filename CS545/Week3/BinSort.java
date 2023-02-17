package CS545.Week3;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class BinSort {
  /**
   * Bin sort
   * @param arr array of elements, where each element has an integer key >= 0
   * @param maxValue largest value of any key in the array
   */
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
      Elem current  = arr[i];
      int key = current.getKey();
      bins[key].add(current); //adds current to the end of the bin

    }

    // Iterate over the bins and place elements back into arr
    int count  = 0;
    for (int k = 0; k <= maxValue; k++) {
      LinkedList<Elem> list  = bins[k];
      Iterator<Elem> it = list.iterator();
      while (it.hasNext()) {
        Elem curr = it.next();
        arr[count] = curr;
        count++;
      }
    }
  }

  public static void main(String[] args) {
    Elem[] elements = {
            new Elem(4, "A"), new Elem(0, "B"),
            new Elem(2, "C"), new Elem(4, "D"),
            new Elem(0, "E"), new Elem(1, "F")
    };
    binSort(elements, 10);
    System.out.println(Arrays.toString(elements));
  }
}
