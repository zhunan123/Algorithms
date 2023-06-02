package ShoulderU.Stack.june1;

import java.util.Stack;

public class DecodeString394 {
    public String decodeString(String s) {
        // create number stack
        Stack<Integer> numStack = new Stack<>();
        // create char stack
        Stack<String> strStack = new Stack<>();

        // initialize count, initialize final string
        int count = 0;
        String finalStr = "";

        // start the loop
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // first condition if i is a letter, then increment the count
            if (Character.isDigit(ch)) {
                //need to concatenate all the number say like 100
                count = 10 * count + Character.getNumericValue(ch);
            } else if (Character.isLetter(ch)) { // second condition if ch is a letter, then add it to final ans res;
                finalStr += ch;
            } else if (ch == '[') {
                // third condition if char is (, need to add final str and count into stack;
                numStack.push(count);
                strStack.push(finalStr);

                // also clear out the count and final str
                count = 0;
                finalStr = "";
            } else if (ch == ']') {
                // need to pop two stack first
                int poppedInt = numStack.pop();
                String poppedStr = strStack.pop();
                // write a while loop with poppedNum time, added finalStr to poppedStr
                for (int j = 0; j < poppedInt; j++) {
                    poppedStr += finalStr;
                }
                // update poppedStr to final str
                finalStr = poppedStr;
            }
        }
        return finalStr;
    }
}
