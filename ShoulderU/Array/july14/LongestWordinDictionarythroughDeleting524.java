package ShoulderU.Array.july14;

import java.util.List;

public class LongestWordinDictionarythroughDeleting524 {
  public String findLongestWord(String s, List<String> dictionary) {
    // idea: write a for loop iterate each dictionary in s, in another for loop to interate char in s, if find match, move s and next word, somehow claculate the longest length of dictory

    String ans = "";
    for (String word : dictionary) {
      int i = 0;
      for (char c : s.toCharArray()) {
        // need to have bboundry condition, otherwise word will go outer bound since i is increasing
        if (word.length() == i) {
          break;
        }
        if (word.charAt(i) == c) {
          i++;
        }
      }
      // found the word
      if (i == word.length()) {
        if (word.length() > ans.length()){
          ans = word;
        } else if (word.length() == ans.length()) {
          // handle situation where word have same length, which will compare arphabetic order
          if (word.compareTo(ans) < 0) {
            ans = word;
          }
        }
      }
    }
    return ans;
  }
}
