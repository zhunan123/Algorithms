package ShoulderU.LinkedList.Aug4;

import ShoulderU.LinkedList.Aug3.ListNode;

public class RemoveDuplicatesfromSortedListII82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            if (current.next.val == current.next.next.val) {
                int val = current.next.val;
                while (current.next != null && current.next.val == val) {
                    // remove duplicate
                    current.next = current.next.next;
                }
            } else {
                current = current.next;
            }
        }
        return dummy.next;
    }
}
