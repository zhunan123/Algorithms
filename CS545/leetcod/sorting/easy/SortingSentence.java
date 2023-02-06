package CS545.leetcod.sorting.easy;

public class SortingSentence {
  /**
   * A sentence is a list of words that are separated by a single space with no leading or trailing spaces.
   * Each word consists of lowercase and uppercase English letters.
   * A sentence can be shuffled by appending the 1-indexed word position to each word then rearranging the words in the sentence.
   * For example, the sentence "This is a sentence" can be shuffled as "sentence4 a3 is2 This1" or "is2 sentence4 This1 a3".
   * Given a shuffled sentence s containing no more than 9 words, reconstruct and return the original sentence.
   *
   * Example 1:
   *
   * Input: s = "is2 sentence4 This1 a3"
   * Output: "This is a sentence"
   * Explanation: Sort the words in s to their original positions "This1 is2 a3 sentence4", then remove the numbers.
   * */

  public String sortSentence(String s) { //s = "is2 sentence4 This1 a3"
    String[] str_arr = s.split(" ");
    String[] res = new String[str_arr.length];
    StringBuffer sb = new StringBuffer();

    int i;
    for (String str : str_arr) {
      i = (int) str.charAt(str.length() - 1) - '0';
      res[i - 1] = str.substring(0, str.length() - 1);
    }

    int j;
    for (j = 0; j < res.length; j++) {
      if (j == res.length - 1) {
        sb.append(res[j]);
      } else {
        sb.append(res[j]).append(" ");
      }
    }
    return sb.toString();
  }
}
