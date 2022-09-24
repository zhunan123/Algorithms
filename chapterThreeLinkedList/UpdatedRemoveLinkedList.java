package chapterThreeLinkedList;

public class UpdatedRemoveLinkedList {

    public ListNode removeListNode(ListNode head, int val){
        ListNode prevhead = new ListNode(-1);
        prevhead.next = head;
        ListNode cur = prevhead;

        while(cur != null){
            if(cur.next.val == val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return prevhead.next;
    }
}
