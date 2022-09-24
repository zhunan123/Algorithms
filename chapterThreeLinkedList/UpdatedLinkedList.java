package chapterThreeLinkedList;

public class UpdatedLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val){
            this.val = val;
            next = null;
        }
    }
    //only use one dummy/prevhead
    public ListNode updatedInsertedNode(ListNode head, int val){
        ListNode newNode = new ListNode(val);
        ListNode prevhead = new ListNode(-1);
        prevhead.next = head;
        ListNode cur = prevhead;

        while(cur.next != null && cur.next.val < val){
            cur = cur.next;
        }
        newNode.next = cur.next;
        cur.next = newNode;

        return prevhead.next;
    }
}
