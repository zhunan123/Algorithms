package ShoulderU.HashMap;

import ShoulderU.RecursionTree.june18.ListNode;

public class ReverseLinkedList206Second {
  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode current = head;
    while (current != null) {
      ListNode next = current.next;
      ListNode temp = current;
      current.next = prev;
      prev = temp;
      current = next;
    }
    return prev;
  }
}
