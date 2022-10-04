package QueueStack;

public class ImplementQueue {

    //THIS IS FOR QUEUE METHOD, pop, push, top is for all override method in queue
    //not in stack

    /**
     * this is all implement push pop top with queue.
     * push(1) //push 1 into tail in queue
     * pop(2) //return first in queue
     * push(2)
     * push(3)
     * top()
     * pop()
     * result-------> 1 2 2
     * */

    interface InterfaceQueue {
        void push(int element);
        int pop();
        int top();
    }


    public class MyQueue implements InterfaceQueue {
        public MyQueue() {
            // do initialization if necessary
        }

        public class ListNode {
            int val;
            ListNode next;
            public ListNode(int val) {
                this.val = val;
                next = null;
            }
        }

        public ListNode dummyNode = new LinkedNode(-1);
        public ListNode tail = dummyNode;

        @Override
        public void push(int val) {
            ListNode newNode = new ListNode(val);
            tail.next = newNode;
            tail = tail.next;
        }

        @Override
        public int pop() {
            if (dummyNode.next == null) {
                throw new NullPointerException();
            }
            int val = dummyNode.next.val;
            dummyNode = dummyNode.next;
            return val;
        }

        @Override
        public int top() {
            if (dummyNode.next == null) {
                throw new NullPointerException();
            }
            return dummyNode.next.val;
        }
    }
}
