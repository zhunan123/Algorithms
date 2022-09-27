package chapterThreeLinkedList;

public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        // write your code here
        ListNode prevhead = new ListNode(-1);
        prevhead.next = head;
        ListNode temp = prevhead;
        while(temp.next != null && temp.next.next !=null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }

        return prevhead.next;
    }
}
