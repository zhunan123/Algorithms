package ShoulderU.QueueMinHeap.june15;

import java.util.PriorityQueue;

public class RemoveStonestoMinimizetheTotal1962 {
    public int minStoneSum(int[] piles, int k) {
        // create max heap
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);

        // add piles to pq
        for (int i = 0; i < piles.length; i++) {
            heap.offer(piles[i]);
        }

        // start while loop to operate k times
        while (k-- > 0) {
            //poll top and operate to remove stones
            int top = heap.poll();
            int remaining = top - (int) Math.floor(top / 2);
            // add remaining back into heap
            heap.offer(remaining);
        }

        // define sum
        int sum = 0;

        // find the total number of sum after k times operations
        while(heap.size() > 0) {
            sum += heap.poll();
        }

        // return sum
        return sum;
    }
}
