package ShoulderU.QueueMinHeap.july26;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairswithSmallestSums373 {

  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {


    // second method using priority queue min heap(min heap is build based on two sum of int pair)
    // we have nums1 = [1,7,11], nums2 = [2,4,6], k = 3
    /**
     idea is that we only add [1,2] [7,2] [11,2] into minHeap we added only 3 since k = 3, then we pop the smallest sum one which is [1,2] and add to final array. then move [1,2] to next in this row which is [1,4] add to minheap, and we compare all three(actually dont need to compare since heap top is already the smallest), so just pop smallest from minheap and add smallest to final array until we find all k element;
     // idea is just pop the current top and add the next, then pop k times
     */

    // first initialize the heap
    PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>((a, b) -> (a.get(0) + a.get(1)) - (b.get(0) + b.get(1)));

    // add first k element into minHeap, first element in nums2 and pair with each element in nums1
    for (int i = 0; i < nums1.length && i < k; i++) {
      List<Integer> list = new ArrayList<>();
      list.add(nums1[i]);
      list.add(nums2[0]);
      minHeap.offer(list);
    }

    //poll the first k smallest element
    // initialize final and array
    int j = 0; // track position of smallest.get(1);
    int count = 0;
    List<List<Integer>> ans = new ArrayList<>();
    while (!minHeap.isEmpty() && count++ < k) {
      // poll current minHeap and add to ans array
      List<Integer> smallest = minHeap.poll();
      ans.add(new ArrayList<>(smallest).subList(0, 2)); // here need to deep copy

      // move the current array to next array and add into minheap
      // if we have reach to the end of one row, continue to next row
      if (smallest.get(2) == nums2.length - 1) {
        continue;
      }
      List<Integer> nextList = new ArrayList<>();
      nextList.add(smallest.get(0));
      nextList.add(nums2[smallest.get(2) + 1]);
      nextList.add(smallest.get(2) + 1);
      minHeap.offer(nextList);
    }
    return ans;
  }
}
