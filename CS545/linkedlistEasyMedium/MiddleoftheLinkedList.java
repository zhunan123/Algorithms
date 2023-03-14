package CS545.linkedlistEasyMedium;

public class MiddleoftheLinkedList {

    /**
     * Given the head of a singly linked list, return the middle node of the linked list.
     *
     * If there are two middle nodes, return the second middle node.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: head = [1,2,3,4,5]
     * Output: [3,4,5]
     * Explanation: The middle node of the list is node 3.
     * Example 2:
     *
     *
     * Input: head = [1,2,3,4,5,6]
     * Output: [4,5,6]
     * Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
     * */

    /**
     * have 2 node fast and slow
     * first check if linkedlist has odd element, then we have exact 1 mid. so we can use line 34-38, and only need to return slow
     * else case if we have even elements in linkedlist, means we have 2 mids, so line 40 if fast.next != null will check if has even elements
     * then we return slow.next
     * */
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast.next != null) {
            return slow.next;
        } else {
            return slow;
        }
    }
}
