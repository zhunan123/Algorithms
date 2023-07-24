package ShoulderU.Stack.july23;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluateReversePolishNotation150 {

  public int evalRPN(String[] tokens) {
    // idea : create stack loop and  res; through the string array if is integer then add to stack, if is operator, then operate the previous 2 integer from stack.pop then operate then with operator and calculate the result, then add result to the stack. final when loop is break, do stack pop to return final ans

    int result = 0;
    Deque<Integer> stack = new ArrayDeque<>();

    for (int i = 0; i < tokens.length; i++) {
      if (Character.isDigit(tokens[i].charAt(0)) || tokens[i].length() > 1) {
        stack.addLast(Integer.valueOf(tokens[i]));
      } else {
        if (tokens[i].equals("+")) {
          int int1 = stack.removeLast();
          int int2 = stack.removeLast();
          result = int1 + int2;
        }
        if (tokens[i].equals("-")) {
          int int1 = stack.removeLast();
          int int2 = stack.removeLast();
          result = int2 - int1;
        }
        if (tokens[i].equals("*")) {
          int int1 = stack.removeLast();
          int int2 = stack.removeLast();
          result = int1 * int2;
        }
        if (tokens[i].equals("/")) {
          int int1 = stack.removeLast();
          int int2 = stack.removeLast();
          result = int2 / int1;
        }
        stack.addLast(result);
      }
    }
    return stack.removeLast();
  }
}
