package chapterThreeLinkedList;

public class MiddleNode {

    //建立一个fast，一个slow，fast走两格，low走一格，当fast走到返回low就是linked list middle point;

    public ListNode findMiddleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        if(head == null){
            return null;
        }

        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
