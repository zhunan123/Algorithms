package ShoulderU.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsofaPhoneNumber17_2 {
    // define ans
    List<String> ans = new ArrayList<>();
    // defind map
    Map<Character, String> letters = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
    // defind variables
    String phoneDigits;
    public List<String> letterCombinations(String digits) {
        // define edge case
        if (digits.length() == 0) {
            return ans;
        }

        phoneDigits = digits;
        // define backtrack function
        backtrack(0, new StringBuilder());

        // return ans
        return ans;
    }

    // defind backtrack function
    public void backtrack(int index, StringBuilder path) {
        // base case
        if (path.length() == phoneDigits.length()) {
            ans.add(path.toString());
            return;
        }

        // recursive  case
        // start loop current key character in map
        String letterArray = letters.get(phoneDigits.charAt(index));
        for (char ch : letterArray.toCharArray()) {
            // add current char
            path.append(ch);
            // go to next char
            backtrack(index + 1, path);
            // done with next char, backtrack to cuurent char, backtrack remove the last letter before goto next one
            path.deleteCharAt(path.length() - 1);
        }
    }
}
