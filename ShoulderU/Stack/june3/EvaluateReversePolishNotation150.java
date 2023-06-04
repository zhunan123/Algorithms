package ShoulderU.Stack.june3;

import java.util.Stack;

public class EvaluateReversePolishNotation150 {

    /**
     * classic stack, create stack and result, start loop the string[] tokens,
     * if is positive digit or negative digit or large digit, push to stack and continue, if i + - * / operator,
     * start to pop twice in stack, and operate these 2 popped number assigned to result. after that push rsult into stack.
     * finally return stack.pop()
     * */
    public int evalRPN(String[] tokens) {
        // ["144","-123","+"]
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < tokens.length; i++) {
            if (Character.isDigit(tokens[i].charAt(0)) || tokens[i].length() > 1) { // check if is digit, if is digit no matter is positive or negative, add to stack, tokens[i].length() > 1 means positive/negative integer like 333/-333
                stack.push(Integer.valueOf(tokens[i]));
                continue;
            } else if (tokens[i].equals("+")) {
                // check condition if is +
                int poppedPrev = stack.pop();
                int poppedBeforePrev = stack.pop();
                result = poppedPrev + poppedBeforePrev;
            } else if (tokens[i].equals("-")) {
                // check condition if is -
                int poppedPrev = stack.pop();
                int poppedBeforePrev = stack.pop();
                result = poppedBeforePrev - poppedPrev;
            } else if (tokens[i].equals("*")) {
                // check condition if is *
                int poppedPrev = stack.pop();
                int poppedBeforePrev = stack.pop();
                result = poppedPrev * poppedBeforePrev;
            } else if (tokens[i].equals("/")) {
                // check condition if is /
                int poppedPrev = stack.pop();
                int poppedBeforePrev = stack.pop();
                result = poppedBeforePrev / poppedPrev;
            }
            stack.push(result);
        }
        // return final result
        return stack.pop();
    }
}
