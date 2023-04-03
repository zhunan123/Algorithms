package CS545.week6.stack.leetcode;

import java.util.Stack;

public class ValidParentheses {
    /**
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     *
     * An input string is valid if:
     *
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     * Every close bracket has a corresponding open bracket of the same type.
     *
     *
     * Example 1:
     *
     * Input: s = "()"
     * Output: true
     * Example 2:
     *
     * Input: s = "()[]{}"
     * Output: true
     * Example 3:
     *
     * Input: s = "(]"
     * Output: false
     * */

    public boolean isValid(String s) {
        String[] arr = s.split("");
        if (arr.length == 1) {
            return false;
        }
        //edge case if only one side of parenthese, return false;
        Stack<String> stack = new Stack<>();
        int count = 0;

        //need to be in order in condition like "([)]" this is not valid
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("(") || arr[i].equals("[") || arr[i].equals("{")) {
                count++;
                stack.push(arr[i]);
            } else {
                if (!stack.isEmpty()) {
                    String str = stack.pop();
                    if (arr[i].equals(")")) {
                        if (str.equals("(")) {
                            count--;
                        }
                    } else if (arr[i].equals("]")) {
                        if (str.equals("[")) {
                            count--;
                        }
                    } else {
                        if (str.equals("{")) {
                            count--;
                        }
                    }
                } else { // if stack is empty return false
                    return false;
                }
            }
        }
        return count == 0 ? true : false;
    }
}
