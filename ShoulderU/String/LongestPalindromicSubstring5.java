package ShoulderU.String;

public class LongestPalindromicSubstring5 {
  public String longestPalindrome(String s) {
    // brute-force traverse all string and check if is palindrom so time complexity if O(n^3)
    // better solution. expand from mid, have two pointer in the middle and expand out world, and check if all chararctoer are same, answer will be either find not match or went out of bound
    // https://www.youtube.com/watch?v=y2BD4MJqV20&ab_channel=NickWhite

    // "aabbaa" - case2
    int maxLength = 0;
    int left = 0, right = 0;
    if (s == null || s.length() == 0){
      return "";
    }
    for (int i = 0; i < s.length(); i++) {
      //"racecar" - case1
      int length1 = expandFromMiddle(s, i, i);
      // "aabbaa" - case2
      int length2 = expandFromMiddle(s, i, i + 1);
      int max = Math.max(length1, length2);
      // setting new boundry for the max palindrom
      if (max > (right - left)) {
        left = i - ((max - 1)/ 2);
        right = i + max / 2;
      }
    }
    return s.substring(left, right + 1);
  }

  public int expandFromMiddle(String s, int left, int right) {
    if (s == null || left > right) {
      return 0;
    }
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      right++;
      left--;
    }
    return right - left - 1;
  }
}
