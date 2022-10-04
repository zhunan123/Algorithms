package QueueStack;

import java.util.Stack;

public class ImplementQueueUsingStack {

    public class MyQueue {
        Stack<Integer> s1;
        Stack<Integer> s2;
        public MyQueue() {
            s1 = new Stack<Integer>();
            s2 = new Stack<Integer>();
        }
        //create 2 stack stack1 store data stack2 help operation
        //s1入栈新的val
        //pop s2!=empty return s2pop else s2push s1pop  return s2pop
        //top s2!=empty return s2peek else s2push s1pop return s2peek

        public void push(int element) {
            s1.push(element);
        }

        public int pop() {
            if(!s2.isEmpty()){
                return s2.pop();
            }

            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }

            return s2.pop();
        }

        public int top() {
            if(!s2.isEmpty()){
                return s2.peek();
            }

            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            return s2.peek();
        }
    }
}
