package CS545.week6.stack.leetcode;

import java.util.Stack;

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();

        int longest = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else {
                if (!stack.isEmpty()) {
                    char c = stack.pop();
                    if (c == '('){
                        longest += 2;
                        count = longest;
                    }
                } else {
                    longest = 0;
                }

            }
        }
        while (!stack.isEmpty()) {
            longest -= 2;
            count -= 2;
            stack.pop();
        }
        return Math.max(longest, count);
    }

    public static void main(String[] args) {
        LongestValidParentheses longs = new LongestValidParentheses();
        longs.longestValidParentheses("()(()");
    }
}
