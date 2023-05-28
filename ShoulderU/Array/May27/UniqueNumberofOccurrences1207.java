package ShoulderU.Array.May27;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class UniqueNumberofOccurrences1207 {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // create a hash set
        Set<Integer> set = new HashSet(map.values());

        // check if the size is same
        if (map.size() == set.size()) {
            return true;
        }
        return false;
    }
}
