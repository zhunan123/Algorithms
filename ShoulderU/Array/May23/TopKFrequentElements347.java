package ShoulderU.Array.May23;

import java.util.*;

public class TopKFrequentElements347 {
    public int[] topKFrequent(int[] nums, int k) {
        // crate res array
        int[] res = new int[k];

        // initialize hashmap
        Map<Integer, Integer> map = new HashMap<>();

        // add array element into the hashmap
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        // create a list contains hashmap entries
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        // sort the list that contains hashmap entries based on the hashmap value
        Collections.sort(list, (a, b) -> b.getValue() - a.getValue());

        //add top K elements into res array
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i).getKey();
        }

        // return answer arr
        return res;
    }
}
