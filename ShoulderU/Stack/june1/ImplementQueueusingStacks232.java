package ShoulderU.Stack.june1;

import java.util.Stack;

public class ImplementQueueusingStacks232 {
    public ImplementQueueusingStacks232() {

    }
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int x) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(x);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public int pop() {
        if (!stack1.isEmpty()) {
            return stack1.pop();
        } else {
            return -1;
        }
    }

    public int peek() {
        if (!stack1.isEmpty()) {
            return stack1.peek();
        } else {
            return -1;
        }
    }

    public boolean empty() {
        return stack1.isEmpty();
    }
}
