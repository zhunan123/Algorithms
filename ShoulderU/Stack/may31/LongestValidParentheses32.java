package ShoulderU.Stack.may31;

import java.util.Stack;

public class LongestValidParentheses32 {
    public int longestValidParentheses(String s) {
        /**
         * create stack, define longest, push starting border, iterate loop string s,
         * if char is ( push into stack, else.first pop stack, after pop stack1.
         * if stack is empty, means we have poped the previous border, need to update the current index into the new border index.
         * 2. if the stack is not empty means we are still in the process that finding the longest valid string,
         * so compute longest which will compare the previous longest and the difference current index i - index number of the current border which will be the longest.
         * */

        /**
         * pop stack 的时候 如果为空，就是pop掉之前的边界，然后更新边界到现在的index
         * 如果不为空，那就是之前的边界还在，就是找到了valid closing parenthesis ), 然后就是更新longest valid length
         * */

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
                    //更新边界, 如果是） 并且pop完为空，说明之前的是一个老的边界以及一串valid parenthesis，pop掉老的边界，然后更新更新边界到当前index
                    stack.push(i);
                } else {
                    //计算longest
                    // 如果是) 并且stack pop完不为空，就说明找到valid parathesist, 更新longest, stack.peek()是当前边界所在的位置
                    longest = Math.max(longest, i - stack.peek());
                }
            }
        }
        return longest;
    }
}
