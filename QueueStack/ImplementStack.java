package QueueStack;

public class ImplementStack {


    interface InterfaceQueue {
        void push(int element);

        // define an interface for pop method
        /* write your code here */
        int pop();

        // define an interface for top method
        /* write your code here */
        int top();
    }


    public class MyQueue implements InterfaceQueue {
        /* you can declare your private attributes here */
        public MyQueue() {
            // do initialization if necessary
        }

        class LinkedNode {
            int val;
            LinkedNode next;
            public LinkedNode(int val) {
                this.val = val;
            }
        }

        public LinkedNode dummyNode = new LinkedNode(-1);
        public LinkedNode tail = dummyNode;

        // implement the push method
        /* write your code here */
        @Override
        public void push(int val) {
            LinkedNode newNode = new LinkedNode(val);
            tail.next = newNode;
            tail = tail.next;
        }

        // implement the pop method
        /* write your code here */
        @Override
        public int pop() {
            if (dummyNode.next == null) {
                throw new NullPointerException();
            }
            int val = dummyNode.next.val;
            dummyNode = dummyNode.next;
            return val;
        }

        // implement the top method
        /* write your code here */
        @Override
        public int top() {
            if (dummyNode.next == null) {
                throw new NullPointerException();
            }
            return dummyNode.next.val;
        }
    }
}
