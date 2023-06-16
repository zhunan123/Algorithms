package ShoulderU.QueueMinHeap.june14;

import java.util.PriorityQueue;

public class LastStoneWeight1046 {
    public int lastStoneWeight(int[] stones) {
        // create priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);

        // add stones to pq
        for (int stone : stones) {
            pq.offer(stone);
        }

        // start to smash
        while (pq.size() > 1) {
            int stone1 = pq.poll();
            int stone2 = pq.poll();
            int newStone = Math.abs(stone1 - stone2);
            // add new stone back into pq
            if (newStone != 0) { // if x == y, both stone is destroyed
                pq.offer(newStone);
            }
        }

        // if only one left return last stone or return 0 if no stone left
        return pq.size() == 1 ? pq.poll() : 0;
    }
}
