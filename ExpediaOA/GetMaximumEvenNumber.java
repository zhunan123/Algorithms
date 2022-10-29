package ExpediaOA;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class GetMaximumEvenNumber {
    public static long getMaximumEvenSum(List<Integer> val) {
        long res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : val) {
            if (num % 2 == 0) {
                if (num >= 0) {
                    res += num;
                }
            }else {
                pq.add(num);
            }
        }
        while (pq.size() >= 2) {
            int a1 = pq.poll();
            int a2 = pq.poll();
            if (a1 + a2 > 0) {
                res += a1 + a2;
            }else {
                break;
            }
        }
        return res;
    }
}
