package CS545.week9.LeetCode;

import java.util.PriorityQueue;

public class MaximumProductofTwoElementsinanArray {
    /**
     * Given the array of integers nums, you will choose two different indices i and j of that array. Return the maximum value of (nums[i]-1)*(nums[j]-1).
     *
     *
     * Example 1:
     *
     * Input: nums = [3,4,5,2]
     * Output: 12
     * Explanation: If you choose the indices i=1 and j=2 (indexed from 0), you will get the maximum value, that is, (nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12.
     * */

    //using priority queue(default priority queue is build on min heap) with min heap,
    // call the removeMin until have last two element left,
    // then we know those 2 element are top largestest, then compute the sum

    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        //when add in priority queue, it will insert the element into minheap, and build the minheap for you
        for (int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);
        }

        //poll heap until have last two left
        while (minHeap.size() > 2) {
            minHeap.poll();
        }
        return (minHeap.poll() - 1) * (minHeap.poll() - 1);
    }
}
