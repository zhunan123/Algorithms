package chapterThreeLinkedList;

public class RotateRight {

    public static int getLength(ListNode head){
        int len = 0;
        while(head != null){
            len++;
            head = head.next;
        }
        return len;
    }
    public ListNode rotateRight(ListNode head, int n) {
        if(head == null){
            return null;
        }

        ListNode prevhead = new ListNode(-1);
        prevhead.next = head;

        int len = getLength(head);
        int cnt = n % len;

        ListNode ahead = prevhead;
        for(int i=0;i<cnt;i++){
            ahead = ahead.next;
        }

        ListNode behind = prevhead;
        while(ahead.next != null){
            ahead = ahead.next;
            behind = behind.next;
        }

        ahead.next = prevhead.next;
        prevhead.next = behind.next;
        behind.next = null;

        return prevhead.next;
    }
}
