package CS545.linkedlistEasyMedium;

public class ConvertBinaryNumberLinkedListtoInteger {


    /**
     * Given head which is a reference node to a singly-linked list.
     * The value of each node in the linked list is either 0 or 1.
     * The linked list holds the binary representation of a number.
     *
     * Return the decimal value of the number in the linked list.
     *
     * The most significant bit is at the head of the linked list.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: head = [1,0,1]
     * Output: 5
     * Explanation: (101) in base 2 = (5) in base 10
     * Example 2:
     *
     * Input: head = [0]
     * Output: 0
     * */
    //this method help to convert base 2 to base 10

    public int getDecimalValue(ListNode head) {
        int sum = 0;
        ListNode curr = head;
        while (curr != null) {
            sum = sum * 2 + curr.val;
            curr = curr.next;
        }
        return sum;
    }
}
