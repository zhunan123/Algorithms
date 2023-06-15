package ShoulderU.QueueMinHeap.june14;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;

public class ReduceArraySizetoTheHalf1338 {
  public int minSetSize(int[] arr) {
    // map the arr
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
    }

    // sort the map based on frequency and add to the heap
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
      int compare = map.get(b) - map.get(a);
      if (compare == 0){
        return a.compareTo(b);
      }
      return compare;
    });

    // remove duplicate when adding the array into minheap and create a deep copy using hashset
    // otherwise duplicate number will be add into priority queue multiple time to occur issue
    HashSet<Integer> set = new HashSet<>();
    for (int ar : arr) {
      set.add(ar);
    }
    // put the set back into arr1
    int[] arr1 = new int[set.size()];
    int index = 0;
    for (int num : set) {
      arr1[index++] = num;
    }


    //add arr to minheap
    for (int i = 0; i < arr1.length; i++){
      pq.offer(arr1[i]);
    }

    //removeMin, have a count, count + 1 each time,  when sum freq adds up to half of arr size we return count
    int count = 0;
    int sumFreq = 0;
    while (sumFreq < arr.length / 2) {
      sumFreq += map.get(pq.poll());
      count++;
    }

    return count;
  }
}
