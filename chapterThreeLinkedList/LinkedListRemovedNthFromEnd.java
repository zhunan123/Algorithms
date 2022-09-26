package chapterThreeLinkedList;

public class LinkedListRemovedNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here

        ListNode prevhead = new ListNode(-1);
        prevhead.next = head;
        ListNode cur = prevhead;
        int leng = getLength(head);
        for(int i=0;i<leng - n;i++){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return prevhead.next;
    }

    public int getLength(ListNode head){
        int len = 0;
        while(head != null){
            len++;
            head = head.next;
        }
        return len;
    }
}
