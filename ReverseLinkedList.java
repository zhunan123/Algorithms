public class ReverseLinkedList {
    /*
    * null->1->2->3->null
    * null->3->2->1->null
    * */

    public ListNode reverse(ListNode head) {
        /**
         * @param head: n
         * @return: The new head of reversed linked list.
         */
        // write your code here
        if (head == null || head.next == null){
            return head;
        }

        ListNode prev = null;
        ListNode cur = head;

        while (cur !=null ) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
}
