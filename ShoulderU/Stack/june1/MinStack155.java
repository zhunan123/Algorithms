package ShoulderU.Stack.june1;

import java.util.Stack;

public class MinStack155 {
    public MinStack155() {

    }


    // create regular stack and min stack which only add smaller value into min stack
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    public void push(int val) {
        if (stack.isEmpty()) { // if stack is empty, push val into both stack and min stack
            stack.push(val);
            minStack.push(val);
        } else {
            // if stack is not empty, first push to regular stack
            // then 2 condition, if val < minStack.peek(), push val to minStack, if val > minStack.peek(), then push the minStack.peek(), push again previous minStack top to minStack
            stack.push(val);
            if (val < minStack.peek()) {
                minStack.push(val);
            } else { // say minStack has top -2, then we push 0 which is greater than -2, so we push -2 againto into minstack which will have -2, -2
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
