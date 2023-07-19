package ShoulderU.Stack.july18;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses20 {
  public boolean isValid(String s) {
    // (()
    // ())

    if (s.length() == 1) {
      return false;
    }

    Deque<Character> stack = new ArrayDeque<>();

    int count = 0;

    for (char ch : s.toCharArray()) {
      if (ch == '(' || ch == '{' || ch == '[') {
        stack.addLast(ch);
        count++;
      } else {
        if (!stack.isEmpty()) {
          if (ch == ')' && stack.removeLast() == '(') {
            count--;
          }
          if (ch == '}' && stack.removeLast() == '{') {
            count--;
          }
          if (ch == ']' && stack.removeLast() == '[') {
            count--;
          }
        } else {
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
