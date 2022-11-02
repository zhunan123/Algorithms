package TIkTokOA;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExchangeCups {
    /**
     * The store has a lot of cups, numbered 1 ~N on the shelf. For example, there are 5 cups:
     * 21354
     * Ask to pick up 2 cups at a time and swap their positions. After several times, the serial number of the cups is made:
     * 12345
     * For such a simple case, obviously, at least 2 swaps are required to reset.
     * The input format is two lines:
     * Line 1: A positive integer N (N < 10000) representing the number of bottles
     * Second line: N positive integers, separated by spaces, indicating the current arrangement of the bottles.
     * The output data is a positive integer in a row, indicating at least how many times to swap to complete the sorting.
     * */

    public static void union(long i, long j) {
        Map<Long, Long> map = new HashMap<>();
        long pi = get(i);
        long pj = get(j);
        if ( pi != pj) {
            map.put(pi , pj) ;
        }
    }

    public static long exchange_cups(List<Long> labels) {
        Map<Long, Long> map = new HashMap<>();
        for(Long label : labels) {
            map.put(label, label);
        }
        int n = labels.size();
        long res = 0;
        for(int i =0 ;i < labels.size(); ++i) {
            union(i+ 1, labels.get(i));
        }
        Map<Long, Integer> sizeMap = new HashMap<>();
        for (int i = 1;i <= n; i++) {
            long p = get(i);
            sizeMap.put(p, sizeMap.getOrDefault(p, 0)+1);
        }
        for(Integer value : sizeMap.values()) {
            res+= value - 1;
        }
        return res;
    }

    private static long get(long i) {
        return i;
    }
}
