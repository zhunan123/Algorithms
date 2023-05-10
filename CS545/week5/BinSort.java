package CS545.week5;

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
    LinkedList<Elem>[] bins = new LinkedList[maxValue+1]; // array of linked list, since we start key is from 0 to maxValue. so create maxValue + 1 linked list array
    // Initialize all the linked lists
    for (i = 0; i <= maxValue; i++) // create maxVal + 1 of linked list
      bins[i] = new LinkedList<>();

    // Iterate over arr; get the key of each element
    // and place the element in the corresponding bin:
    // the index of the bin is equal to the key
    //where to put element into correct linked list
    for (i = 0; i < arr.length; i++) {
      Elem current  = arr[i];
      int key = current.getKey();
      bins[key].add(current); //adds current to the end of the bin

    }

    // Iterate over the bins and place elements back into arr
    //when you have the linked list all filled , put the linked list back to input array
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

  public static void binSort2(Elem[] arr, int maxValue) {

    LinkedList<Elem>[] bins = new LinkedList[maxValue + 1];

    for (int i = 0; i <= maxValue; i++) {
      bins[i] = new LinkedList<>();
    }

    for (int j = 0; j < arr.length; j++) {
      int binId = arr[j].getKey();
      bins[binId].add(arr[j]);
    }

    for (int k = 0; k < bins.length; k++) {
      if (bins[k] == null) {
        continue;
      }
      LinkedList<Elem> list = bins[k];
      Iterator<Elem> it = list.iterator();
      int count = 0;
      while (it.hasNext()) {
        Elem current = it.next();
        arr[count] = current;
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
