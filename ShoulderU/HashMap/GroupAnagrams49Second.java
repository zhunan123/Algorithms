package ShoulderU.HashMap;

import java.util.*;

public class GroupAnagrams49Second {
  public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> ans = new ArrayList<>();
    HashMap<String, List<String>> map = new HashMap<>();
    // HashMap---"abc"(String.valueOf(sorted char[])) --> ["abc", "cba", "bca"]
    for (String str : strs) {
      char[] arr = str.toCharArray();
      // use Array.sort() to sort int[], char[]
      // use Collections.sort() to sort arrayList, linkedList
      Arrays.sort(arr);
      String newStr = String.valueOf(arr);
      if (map.containsKey(newStr)) {
        List<String> list = map.get(newStr);
        list.add(str);
      } else {
        List<String> innerList = new ArrayList<>();
        innerList.add(str);
        map.put(newStr, innerList);
      }
    }
    for (Map.Entry<String, List<String>> entry : map.entrySet()){
      ans.add(entry.getValue());
    }
    return ans;
  }
}
