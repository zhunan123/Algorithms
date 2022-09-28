package QueueStack;

public class EnqueueAndDequeue {

    public class MyQueue {

        ListNode prevhead = new ListNode(-1);
        ListNode end = prevhead;
        public void enqueue(int item) {
            // write your code here
            ListNode newNode = new ListNode(item);
            end.next = newNode;
            end = end.next;
        }

        /*
         * @return: An integer
         */
        public int dequeue() {
            // write your code here

            if(prevhead.next == null) {
                return -1;
            }
            int val = prevhead.next.val;
            prevhead = prevhead.next;
            return val;
        }
    }
}
