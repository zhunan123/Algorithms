package ShoulderU.Stack;

import java.util.Stack;

public class MinStack {

  /**
   * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
   *
   * Implement the MinStack class:
   *
   * MinStack() initializes the stack object.
   * void push(int val) pushes the element val onto the stack.
   * void pop() removes the element on the top of the stack.
   * int top() gets the top element of the stack.
   * int getMin() retrieves the minimum element in the stack.
   * You must implement a solution with O(1) time complexity for each function.
   *
   *
   *
   * Example 1:
   *
   * Input
   * ["MinStack","push","push","push","getMin","pop","top","getMin"]
   * [[],[-2],[0],[-3],[],[],[],[]]
   *
   * Output
   * [null,null,null,null,-3,null,0,-2]
   *
   * Explanation
   * MinStack minStack = new MinStack();
   * minStack.push(-2);
   * minStack.push(0);
   * minStack.push(-3);
   * minStack.getMin(); // return -3
   * minStack.pop();
   * minStack.top();    // return 0
   * minStack.getMin(); // return -2
   * */

  /**
   * 先建立一个stack 一个min stack，push 的话，如果stack是空，两个stack就直接push，然后stack不为空，先吧当前elementpush stack，
   * 然后比较当前element和和min stack top大小，如果小，就push min stack， min stack只方最小的，如果大的话就重新push一次min stack top。
   * pop的话就pop stack 和min stack, top 就看stack的top ，getMin就看min stack的top
   * */

    public MinStack() {

    }

    Stack<Integer> minStack = new Stack<>();
    Stack<Integer> stack = new Stack<>();
    public void push(int val) {
      if (stack.isEmpty()) {
        stack.push(val);
        minStack.push(val);
      } else {
        stack.push(val);
        if (val < minStack.peek()) {
          minStack.push(val);
        } else {
          minStack.push(minStack.peek());
        }
      }
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
      } else {
        return -1;
      }
    }

    public int getMin() {
      if (!minStack.isEmpty()) {
        return minStack.peek();
      } else {
        return -1;
      }
    }
}
