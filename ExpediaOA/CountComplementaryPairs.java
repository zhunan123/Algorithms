package ExpediaOA;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountComplementaryPairs {

    public static long countCountComplementaryPairs(List<String> stringData) {
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
