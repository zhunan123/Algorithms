package CS545.linkedlistEasyMedium;

public class ReverseLinkedList {

    /**
     * Given the head of a singly linked list, reverse the list, and return the reversed list.
     *
     * Example 1:
     *
     * Input: head = [1,2,3,4,5]
     * Output: [5,4,3,2,1]
     * Example 2:
     *
     *
     * Input: head = [1,2]
     * Output: [2,1]
     * */

    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        /**
         * be sure in this while loop cannot be below, since we are setting curr.next = prev already
         * then we do curr = curr.next will not advance to next element, will be be null(prev)
         * curr.next = prev;
         * prev = curr;
         * curr = curr.next;
         * */
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
