package JPMorganOA;

import java.util.List;
import java.util.PriorityQueue;

/**
 * 第二题：给一个数组list，每次抽出两个记录他们的和作为cost，然后把cost加回到list里面，直达list里面只剩下一个number，问所有的cost总和最小为多少
 * Given an array, reduce the array to a single element with minimum cost. For reducing, remove two elements from the array,
 * add those two numbers and keep the sum back in the array. The cost of each operation is the sum of the elements removed in that step.
 * Example, let the array A = [1,2,3]
 * Then, we can remove 1 and 2, add both of them and keep the sum back in array. Cost of this step would be (1+2) = 3.
 * So A = [3,3], Cost = 3
 * In second step, we can remove both elements from the array and keep the sum back in array again. Cost of this step would be 3 + 3 = 6.
 * So, A = [6], Cost = 6
 * So total cost turns out to be 9 (6+3).
 * */
class ReductionCost {
    public static int reductionCost(List<Integer> num) {
        int res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n: num) {
            pq.add(n);
        }
        while(pq.size() >=2) {
            int tmp = pq.poll() + pq.poll();
            res += tmp;
            pq.add(tmp);
        }
        return res;
    }
}
