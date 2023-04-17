package ShoulderU.Stack;

import java.util.Stack;

public class LongestValidParentheses {

    /**
     * Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses
     * substring
     * .
     *
     *
     *
     * Example 1:
     *
     * Input: s = "(()"
     * Output: 2
     * Explanation: The longest valid parentheses substring is "()".
     * Example 2:
     *
     * Input: s = ")()())"
     * Output: 4
     * Explanation: The longest valid parentheses substring is "()()".
     * */

    /**
     * 最开始先加一个边界-1 , 先pop stack, 是 empty 就说明刚才是边界，把边界pop掉了,
     * 然后自己作为新的边界加进来， 如果pop完不为空，则说明最开始的边界还在，
     * 并且还在持续更新新的longest valid parentheses,
     * 然后如果是右括号自己就是边界的话，先pop，然后pop完就是空，就是更新边界位置，
     * pop掉之前的边界，把自己作为新的边界加进去
     * 左多可以累加，右多就要断掉
     * */

    public int longestValidParentheses(String s) {

        Stack<Integer> stack = new Stack<>();
        int longest = 0;
        //push 最开始的边界
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                //最先开始先pop
                stack.pop();
                if (stack.isEmpty()) {
                    //更新边界
                    stack.push(i);
                } else {
                    //计算longest
                    longest = Math.max(longest, i - stack.peek());
                }
            }
        }
        return longest;
    }
}
