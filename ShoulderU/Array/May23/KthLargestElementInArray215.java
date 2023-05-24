package ShoulderU.Array.May23;

import java.util.PriorityQueue;

public class KthLargestElementInArray215 {
    public int findKthLargest(int[] nums, int k) {
        // initialize the max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        // build the max heap
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }

        int removed = 0;
        int i = 0;
        while (i < k) {
            removed = pq.poll();
            i++;
        }

        return removed;
    }
}
