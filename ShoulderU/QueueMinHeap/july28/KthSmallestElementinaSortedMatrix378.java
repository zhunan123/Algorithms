package ShoulderU.QueueMinHeap.july28;

import java.util.PriorityQueue;

public class KthSmallestElementinaSortedMatrix378 {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < matrix.length; i++) {
            int[] current = matrix[i];
            for (int j = 0; j < current.length; j++) {
                heap.add(matrix[i][j]);
            }
        }
        int res = 0;
        while (k-- > 0 && !heap.isEmpty()) {
            res = heap.poll();
        }
        return res;
    }
}
