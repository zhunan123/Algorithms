package ExpediaOA;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountComplementaryPairs {

    public static long countCountComplementaryPairs(List<String> stringData) {
        /**
         * One of the shops in the HackerMall is offering discount coupons bassed on a puzzling problem. There
         * are n tags where each tags has a value denoted by val[i]. a customer needs to choose the rags in such
         * way that the sum of values is even.
         * The goal is to find the maximum possible even sum of values of tags that can be chosen.
         * Example:
         * Tag values are val[2,3,6,-5,10,1,1]
         * Consider some of the following chosen tags and theor corresponding sums:
         *          chosen tags            sum          is sum even?
         *          [2,3,6,10,1,1]         23            No
         *          [2,3,6,-5,10,1,1]      18            Yes
         *          [2,6,10,1,1]           20            Yes
         *          [2,3,6,10,1]           22            Yes
         * The tags[2,3,6,10,1] sum to 22 which is even and is the macimum possible, Hence the answer is 22;
         * */
        Map<Integer, Integer> map = new HashMap<>();
        for (String s : stringData) {
            Integer res = 0;
            for (char c : s.toCharArray()) {
                res ^= (1 << (c - 'a'));
            }
            map.put(res, map.getOrDefault(res, 0) + 1);
        }
        long res = 0;
        for (Integer key : map.keySet()) {
            int num = map.get(key);
            res += (long)num + (num - 1) / 2;
            for (int i = 0; i < 26; i++) {
                if ((key & (1 << i)) > 0) {
                    int temp = key ^ (1 << i);
                    if (map.containsKey(temp)) {
                        res += (long)num * map.get(temp);
                    }
                }
            }
        }
        return res;
    }
}
