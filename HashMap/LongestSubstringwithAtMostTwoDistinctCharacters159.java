package HashMap;

import java.util.HashMap;

public class LongestSubstringwithAtMostTwoDistinctCharacters159 {
  public int lengthOfLongestSubstringTwoDistinct(String s) {
    // HashSet<Character> set = new HashSet<>();
    HashMap<Character, Integer> map = new HashMap<>();
    int left = 0, right = 0;
    int count = 0;
    while (right < s.length()) {
      char ch = s.charAt(right);
      if (!map.containsKey(ch)) {
        if (map.size() < 2) {
          map.put(ch, map.getOrDefault(ch, 0) + 1);
          count = Math.max(count, right - left + 1);
          right++;
        } else {
          count = Math.max(count, right - left);
          char leftChar = s.charAt(left);
          map.put(leftChar, map.get(leftChar) - 1);
          if (map.get(leftChar) == 0){
            map.remove(leftChar);
          }
          left++;
        }
      } else {
        map.put(ch, map.get(ch) + 1);
        count = Math.max(count, right - left + 1);
        right++;
      }
    }
    return Math.max(count, map.size());
  }
}
