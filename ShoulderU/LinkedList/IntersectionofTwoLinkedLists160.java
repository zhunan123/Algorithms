package LinkedList;

public class IntersectionofTwoLinkedLists160 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //https://www.youtube.com/watch?v=IpBfg9d4dmQ&ab_channel=NickWhite
        if (headA == null || headB == null) { return null;}

        ListNode a_pointer = headA;
        ListNode b_pointer = headB;
        while (a_pointer != b_pointer) {
            if (a_pointer == null) {
                a_pointer = headB;
            } else {
                a_pointer = a_pointer.next;
            }

            if (b_pointer == null) {
                b_pointer = headA;
            } else {
                b_pointer = b_pointer.next;
            }
        }

        return a_pointer;
    }
}
