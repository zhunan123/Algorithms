public class RemoveElementsInLinkedList {
    public ListNode removeElements(ListNode head, int val) {

        /**
         * @param head: a ListNode
         * @param val: An integer
         * @return: a ListNode
         */
        // write your code here
        ListNode prevhead = new ListNode(-1);
        ListNode prev = prevhead;
        //id we have head as input, we need below line, other wise we dont need.
        prev.next = head;
        ListNode cur = head;
        while (cur != null){
            if(cur.val == val){
                prev.next = cur.next;
                cur = cur.next;
            }else {
                prev = prev.next;
                cur = cur.next;
            }
        }
        return prevhead.next;

    }
}
