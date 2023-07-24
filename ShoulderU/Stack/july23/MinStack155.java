package ShoulderU.Stack.july23;

import java.util.Stack;

public class MinStack155 {
  public MinStack155() {

  }

  Stack<Integer> stack = new Stack<>();
  Stack<Integer> minStack = new Stack<>();

  public void push(int val) {
    // min stack only push Integer that smaller than top(), if larger than top, push top() again
    if (stack.isEmpty()) {
      minStack.push(val);
    } else {
      if (val < minStack.peek()) {
        minStack.push(val);
      } else {
        minStack.push(minStack.peek());
      }
    }
    stack.push(val);
  }

  public void pop() {
    if (!stack.isEmpty()) {
      stack.pop();
      minStack.pop();
    }
  }

  public int top() {
    if (!stack.isEmpty()) {
      return stack.peek();
    }
    return -1;
  }

  public int getMin() {
    if (!minStack.isEmpty()) {
      return minStack.peek();
    }
    return -1;
  }
}
