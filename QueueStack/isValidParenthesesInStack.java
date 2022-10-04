package QueueStack;

import java.util.Stack;

public class isValidParenthesesInStack {

    public boolean isValidParentheses(String s) {

        //"()[]{}" ---->true
        //"([)]"------>false
        Stack<Character> stack = new Stack<Character>();

        char[] charArr = s.toCharArray();
        for(char c : charArr) {
            if(c == '(') {
                stack.push(')');
            }else if (c == '['){
                stack.push(']');
            }else if(c == '{') {
                stack.push('}');
            }else if(stack.isEmpty() || stack.pop() != c){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
