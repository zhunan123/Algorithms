package CS545.week5;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class BucketSort {

  private static int computeBucketIndex(Elem ele, int size){
    return ele.getKey() / size;
  }

  private static void insertIntoBuckets(Elem elem, LinkedList<Elem> list, LinkedList<Elem>[] buckets, int index) {
    if (elem.getKey() <= list.getFirst().getKey()) {
      elem.next = list.getFirst();
      buckets[index].addFirst(elem);
    } else if (elem.getKey() >= list.getLast().getKey()) {
      buckets[index].getLast().next = elem;
      buckets[index].addLast(elem);
    } else {
      int count = 0;
      Elem cur = list.getFirst();
      while (cur.next != null) {
        if (elem.getKey() < cur.next.getKey()) {
          elem.next = cur.next;
          cur.next = elem;
          list.add(count + 1, elem);
          break;
        } else {
          cur = cur.next;
          count++;
        }
      }
    }
  }

  public static void bucketSort(Elem[] arr, int lowindex, int highindex, boolean reverse) {
    int numberOfBuckets = (highindex - lowindex + 1) / 2;
    int maxValue = 0;
    for (int i = 0; i < arr.length; i++) { //find maxVal
      if (i >= lowindex && i <= highindex) {
        if (arr[i].getKey() > maxValue) {
          maxValue = arr[i].getKey();
        }
      }
    }
    int bucketSize = maxValue / numberOfBuckets + 1;

    LinkedList<Elem>[] buckets = new LinkedList[numberOfBuckets];
    for (int i = 0; i < numberOfBuckets; i++) { //initialize linked list
      buckets[i] = new LinkedList<>();
    }

    for (int i = 0; i < arr.length; i++) { //put elem into correct bucket place
      if (i >= lowindex && i <= highindex) {
        Elem current = arr[i];
        int index = computeBucketIndex(current, bucketSize);
        if (buckets[index].size() == 0) {
          buckets[index].add(current);
        } else {
          insertIntoBuckets(current, buckets[index], buckets, index);
        }
      }
    }

    if (!reverse) {
      int count = lowindex;
      for (int i = 0; i < numberOfBuckets; i++) {
        LinkedList<Elem> list = buckets[i];
        Iterator<Elem> it = list.iterator();
        while (it.hasNext()) {
          Elem curr = it.next();
          arr[count] = curr;
          count++;
        }
      }
    } else {
      int count = highindex;
      for (int i = 0; i < numberOfBuckets; i++) {
        LinkedList<Elem> list = buckets[i];
        Iterator<Elem> it = list.iterator();
        while (it.hasNext()) {
          Elem curr = it.next();
          arr[count] = curr;
          count--;
        }
      }
    }
  }

  public static void main(String[] args) {
    Elem[] elements = {
            new Elem(114, "A"), new Elem(210, "B"),
            new Elem(312, "C"), new Elem(144, "D"),
            new Elem(100, "E"), new Elem(132, "F"),
            new Elem(376, "K"), new Elem(358, "M"),
            new Elem(84, "L")
    };
    bucketSort(elements, 4, 6, true);
    System.out.println(Arrays.toString(elements));
  }
}
