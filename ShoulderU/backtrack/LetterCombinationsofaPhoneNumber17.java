package ShoulderU.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsofaPhoneNumber17 {

    /**
     * // define ans, defind map, defind variables
     * // define edge case,  define backtrack function return ans
     * // base case, define recursive  case, start loop current key character in map, and add the following into the loop.
     * define letterArray, add current char, go to next char, done with next char, backtrack to cuurent char,
     * backtrack remove the last letter before goto next one
     * */
    // create a ans list
    List<String> ans = new ArrayList<String>();

    // create hashmap
    Map<Character, String> map = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");

    // create a copy of digits
    private String digits2;
    public List<String> letterCombinations(String digits) {
        // edge case
        if (digits.length() == 0) {
            return ans;
        }

        digits2 = digits;
        // create backtrack function
        backtrack(0, new StringBuilder());
        return ans;
    }

    public void backtrack(int index, StringBuilder path) {
        // base case check if have equal length
        if (path.length() == digits2.length()) {
            ans.add(path.toString());
            return; // backtrack
        }

        // start to find out all possibilities
        String letters = map.get(digits2.charAt(index)); // get "abc" from "2,3" 中的2
        for (char ch : letters.toCharArray()) {
            path.append(ch); // add current char

            // move to next char
            backtrack(index + 1, path);

            // backtrack remove the last letter before goto next one
            path.deleteCharAt(path.length() - 1);
        }
    }
}
