package ShoulderU.Array.july10;

public class SortList148 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode current = head;
        ListNode prev = null;

        while (current != null && current.next != null) {
            if (current.val < current.next.val) {
                current = current.next;
            } else {
                ListNode insertedNode = current.next;
                current.next = current.next.next;
                prev = dummy;

                while (prev.next.val < insertedNode.val) {
                    prev = prev.next;
                }

                insertedNode.next = prev.next;
                prev.next = insertedNode;
            }
        }

        return dummy.next;
    }
}
