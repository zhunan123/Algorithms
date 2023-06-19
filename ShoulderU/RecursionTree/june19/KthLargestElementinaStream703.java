package ShoulderU.RecursionTree.june19;

import java.util.PriorityQueue;

public class KthLargestElementinaStream703 {
    // use heap priority queue, keep is to only keep k element in the min heap
    PriorityQueue<Integer> heap;
    int k;

    public KthLargestElementinaStream703(int k, int[] nums) {
        // initialize k and min heap
        this.k = k;
        heap = new PriorityQueue<>((a, b) -> a - b);

        // add nums element into max heap
        for (int i = 0; i < nums.length; i++) {
            heap.offer(nums[i]);
        }

        // if heap size > k, poll the previous int, unitl only k int left in the min heap
        while (heap.size() > k) {
            heap.poll();
        }
    }

    public int add(int val) {
        heap.offer(val);
        // if heap size >  so poll()
        if (heap.size() > k) {
            heap.poll();
        }
        return heap.peek();
    }
}
