package ShoulderU.BinarySearch.july1;

import java.util.PriorityQueue;

public class KthSmallestElementinaSortedMatrix378 {
  public int kthSmallest(int[][] matrix, int k) {
    // use maxheap
    PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> a - b);
    // add to queue
    int row = matrix.length;
    int col = matrix[0].length;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        heap.add(matrix[i][j]);
      }
    }
    int count = 0;
    int ans = 0;
    while(!heap.isEmpty()){
      if (count == k) {
        break;
      }
      ans = heap.poll();
      count++;
    }
    return ans;
  }
}
