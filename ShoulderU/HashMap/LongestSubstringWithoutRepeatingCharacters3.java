package ShoulderU.HashMap;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters3 {
  // use sliding window
  // have two pointer, both set at begining, have a maxLength varible to keep track of window size, one pointer1 goes right until we find a same character, then need to update maxLength by doing compare setsize() and maxLngth
  //then if already in set so remove the current char and advance left

  /** #2 butter solution more understandable*/
  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    int maxLength = 0;
    int left = 0, right = 0;
    int length = 0;
    HashSet<Character> set = new HashSet<>();
    while (right < s.length()) {
      // if not in the set, we add to set, move right pointer, add length
      if (!set.contains(s.charAt(right))) {
        set.add(s.charAt(right));
        right++;
        length++;
      } else {
        // if its already in the set, we update the length to maxLength if greater,
        // then we delete left pointer char in set(delete first char)
        // advance left
        // decrement length by one
        if (length > maxLength) {
          maxLength = length;
        }
        set.remove(s.charAt(left));
        left++;
        // then need to decrement the length since since we removed the left
        // this is key
        length--;
      }
    }
    if (length > maxLength) {
      maxLength = length;
    }

    return maxLength;
  }
  public int lengthOfLongestSubstring2(String s) {
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
