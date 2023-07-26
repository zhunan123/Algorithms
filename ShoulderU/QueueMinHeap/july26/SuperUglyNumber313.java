package ShoulderU.QueueMinHeap.july26;

import java.util.PriorityQueue;

public class SuperUglyNumber313 {
  public int nthSuperUglyNumber(int n, int[] primes) {
    // idea: create Number class has value(itself) index(currentIndex to keep track the level), prime(the original prime in primes array), create res int[], create pq, add the first level of original primes array
    // loop from i to n, res[i] == pq.peek().val, then write a while loop res[i] == pq.peek().val, update next Number value and add to pq, has new value current.prime * res[current.index]
    // finally return res[n - 1]


    class Number {
      int val;
      int index;
      int prime;

      public Number(int val, int index, int prime) {
        this. val = val;
        this.index = index;
        this.prime = prime;
      }
    }

    int[] result = new int[n];
    result[0] = 1;
    PriorityQueue<Number> heap = new PriorityQueue<>((a, b) -> a.val - b.val);

    for (int i = 0; i < primes.length; i++) {
      heap.add(new Number(primes[i], 1, primes[i]));
    }

    for (int i = 1; i < n; i++) {
      result[i] = heap.peek().val;
      while (result[i] == heap.peek().val) {
        Number current = heap.poll();
        Number next = new Number(result[current.index] * current.prime, current.index + 1, current.prime);
        heap.add(next);
      }
    }

    return result[n - 1];
  }
}
