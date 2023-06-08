package ShoulderU.QueueMinHeap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairswithSmallestSums373 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // brute force approach#1
        // build priority queue minheap based on sum
         PriorityQueue<List<Integer>> minHeap1 = new PriorityQueue<>((a, b) -> (a.get(0) + a.get(1)) - (b.get(0) + b.get(1)));

        // start adding all premutation into the minheap
         for (int i = 0; i < nums1.length; i++) {
             for (int j = 0; j < nums2.length; j++) {
                 List<Integer> list = new ArrayList<>();
                 list.add(nums1[i]);
                 list.add(nums2[j]);
                 minHeap1.offer(list);
             }
         }

        // initialize count
         int count1 = 0;
        // initialize the final arraylist
         List<List<Integer>> ans1 = new ArrayList<>();
         while (count1 < k && minHeap1.size() != 0) {
             ans1.add(minHeap1.poll());
             count1++;
         }

//         return ans1;


        // second method using priority queue min heap(min heap is build based on two sum of int pair)
        // we have nums1 = [1,7,11], nums2 = [2,4,6], k = 3
        // this approach is better
        /**
         idea is that we only add [1,2] [7,2] [11,2] into minHeap we added only 3 since k = 3,
         then we pop the smallest sum one which is [1,2] and add to final array.
         then move [1,2] to next in this row which is [1,4] add to minheap,
         and we compare all three(actually dont need to compare since heap top is already the smallest),
         so just pop smallest from minheap and add smallest to final array until we find all k element;
        idea is just pop the current top and add the next, then pop k times
         */

        // first initialize the heap
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>((a, b) -> (a.get(0) + a.get(1)) - (b.get(0) + b.get(1)));

        // add first k element into minHeap, first element in nums1 and pair with
        for (int i = 0; i < nums1.length && i < k; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(nums1[i]);
            list.add(nums2[0]);
            // key is to add additional integer to keep track index of nums2 into the list
            // in this case will be [1,2, 0] [7,2,0] [11,2,0]
            list.add(0);
            minHeap.offer(list);
        }

        //poll the first k smallest element
        // initialize final and array
        int count = 0;
        List<List<Integer>> ans = new ArrayList<>();
        while (!minHeap.isEmpty() && count++ < k) {
            // poll current minHeap and add to ans array
            List<Integer> smallest = minHeap.poll();
            ans.add(new ArrayList<>(smallest).subList(0, 2)); // here need to deep copy

            // move the current array to next array and add into minheap
            // if we have reach to the end of one row, continue to next row, and we dont need add anything to minheap
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
