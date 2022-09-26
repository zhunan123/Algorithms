package chapterThreeLinkedList;

public class LinkedListFindNode {

    public ListNode findNode(ListNode head, int val) {
        while(head != null){
            if(head.val == val){
                return head;
            }
            head = head.next;
        }
        return null;
    }
}
