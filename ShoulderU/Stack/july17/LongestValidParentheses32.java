package ShoulderU.Stack.july17;

import java.util.Stack;

public class LongestValidParentheses32 {
    public int longestValidParentheses(String s) {
        // create stack (inside has int index)
        Stack<Integer> stack = new Stack<>();
        // push the starter border (border is the index, first one is imagitative border)
        stack.push(-1);
        // define longest
        int longest = 0;
        // start loop
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    // update new border
                    stack.push(i);
                } else {
                    // calculate longest
                    longest = Math.max(longest, i - stack.peek());
                }
            }
        }
        return longest;
    }
}
