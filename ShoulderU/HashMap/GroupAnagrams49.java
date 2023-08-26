package ShoulderU.HashMap;

import java.util.*;

public class GroupAnagrams49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        //把每个str 都排序一样搞成同样的东西
        //https://www.youtube.com/watch?v=r05M73e30gA&ab_channel=%E8%B4%BE%E8%80%83%E5%8D%9A
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            //when char is being compare the unicode is being compared
            Arrays.sort(arr);
            String formatted_str = String.valueOf(arr);
            if (map.containsKey(formatted_str)) {
                map.get(formatted_str).add(str);
            }else {
                map.put(formatted_str, new ArrayList<>());
                map.get(formatted_str).add(str);
            }
        }
        for (String key : map.keySet()) {
            ans.add(map.get(key));
        }
        return ans;
    }
}
