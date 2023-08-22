package ShoulderU.HashMap;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters3 {
  public int lengthOfLongestSubstring(String s) {
    // have two pointer, both set at begining, have a maxLength varible to keep track of window size, one pointer1 goes right until we find a same character, then need to update maxLength by doing compare setsize() and maxLngth
    //then if already in set so remove the current char and advance left
    if (s == null || s.length() == 0) {
      return 0;
    }
    int left = 0, right = 0;
    int maxLength = 0;
    HashSet<Character> set = new HashSet<>();
    while (right < s.length()) {
      char rightChar = s.charAt(right);
      // 有一部分指示advance right pointer, 但并没有添加rightChar, 到下一轮才会添加
      if (!set.contains(rightChar)) {
        set.add(rightChar);
        right++;
        // each time we see a new character we will need to add it to maxLength
        maxLength = Math.max(set.size(), maxLength);
      } else {
        // 还是需要remove 之前previous duplicated char
        set.remove(s.charAt(left));
        left++;
      }
    }
    return maxLength;
  }
}
