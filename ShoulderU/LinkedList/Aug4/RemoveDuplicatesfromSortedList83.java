package ShoulderU.LinkedList.Aug4;

import ShoulderU.LinkedList.Aug3.ListNode;

public class RemoveDuplicatesfromSortedList83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                // dont move current in this case
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}
