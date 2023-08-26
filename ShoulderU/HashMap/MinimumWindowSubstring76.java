package ShoulderU.HashMap;

public class MinimumWindowSubstring76 {
  /**

   when adding character into table/window (we have a table array with all 128 ascii char with arr[chararcter in t] equals to 1, and other remain 0), in the expand process, , we decrease character appearance by one, after decrease the chararcter appearance in window table, if is not chararcter in t mens will have appearance < 0. once we found a character in t means apprearance after decrease 1 is still >= 0,  if appearance >= 0 means we have found 1 chararcter in t and increment the count. in the shrink process, when satified the condition which means have all char in t found, first need to record the minlenth and update the ans string. which means we need to shrink the window, so we increment the character appearance by one in window table, after we increase the character appearance in window table, if appearance > 0, we decrease the count means we havent find the character since we just shrink the window.

   */

  /**

   flow---> first expand--->after expand we found all character---->then need to shrink left (left--&count--)in while loop unitl at lease 1 character is missing which is not found--->then advance right to keep expand until end of s.length()
   */
  public String minWindow(String s, String t) {
    int[] table = new int[128];
    char[] charArr_s = s.toCharArray();
    char[] charArr_t = t.toCharArray();

    for (char ch : charArr_t) {
      table[(int) ch]++;
    }

    int count = 0;
    int minLength = Integer.MAX_VALUE;
    int left = 0, right = 0;
    String ans = "";

    while (right < s.length()) {
      //expand, decfement appearance
      char rightChar = s.charAt(right);
      table[rightChar]--;
      if (table[(int) s.charAt(right)] >= 0){
        // found 1 character
        count++;
      }
      // right++; need to move this right++ to bottom

      // after expand if we found all char so need to shrink
      while (count == t.length()) {
        int current_length = right - left + 1;
        if (current_length < minLength) {
          minLength = current_length;
          ans = s.substring(left, right + 1);
        }
        // need to decrease the table from left
        // then we increment the appearance in table
        char leftChar = s.charAt(left);
        table[leftChar]++;
        if (table[leftChar] > 0) {
          // found character
          count--;
        }
        left++;
      }

      //after shrink the left, then we need to advance right in the enf here
      right++;
    }
    return ans;
  }
}
