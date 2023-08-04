package ShoulderU.LinkedList.Aug4;

import ShoulderU.LinkedList.Aug3.ListNode;

public class ReverseNodesinkGroup25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        // https://www.youtube.com/watch?v=jTWEmztptCQ
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode current = head;

        while (current != null) {
            int index = 0;
            ListNode tail = current;
            while (current != null && index < k) {
                current = current.next;
                index++;
            }

            if (index == k) {
                prev.next = reverse(tail, k);
                prev = tail;
            } else {
                prev.next = tail;
            }
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head, int k) {
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;

        while (current != null && k-- > 0) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
