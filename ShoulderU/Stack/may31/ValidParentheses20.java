package ShoulderU.Stack.may31;

import java.util.Stack;

public class ValidParentheses20 {
    public boolean isValid(String s) {
        // defind edge case
        if (s.length() == 1) {
            return false;
        }

        // create stack
        Stack<Character> stack = new Stack<>();

        // define count
        int count = 0;

        // iterate string s loop
        for (int i = 0; i < s.length(); i++) {
            // define the current char
            char ch = s.charAt(i);
            // if char is (, {, or [, added it to stack, and increment the count
            if (ch == '{' || ch == '(' || ch == '[') {
                stack.push(ch);
                count++;
            } else {
                // else condition is char is }, ), or ]
                // while stack not empty
                // pop stack, if char is the } match to popped char which is {, ) match to ( and ] math to [, we decrement the count
                if (!stack.isEmpty()) {
                    char popped = stack.pop();
                    if (ch == '}' && popped == '{') {
                        count--;
                    } else if (ch == ')' && popped == '(') {
                        count--;
                    } else if (ch == ']' && popped == '[') {
                        count--;
                    }
                } else {
                    // and return false, if we have the closing char but stack is already empty say we have ) but we dont have (, so return false;
                    return false;
                }
            }
        }
        if (count == 0) {
            return true;
        }
        return false;
    }
}
