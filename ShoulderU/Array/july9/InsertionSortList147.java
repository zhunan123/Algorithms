package ShoulderU.Array.july9;

import ShoulderU.RecursionTree.june18.ListNode;

public class InsertionSortList147 {

  public ListNode insertionSortList(ListNode head) {

    // idea: 就是每个listNode都insert到前面，过程都是head-> insert的地方loop一次
    if (head == null || head.next == null) {
      return head;
    }

    // define dummy, current, prev
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode current = head;
    ListNode prev = null;

    while (current != null && current.next != null) {
      // if current < current.next, keep going and find the node need to be inserted, else find the current.next node < current
      if (current.val <= current.next.val) {
        current = current.next;
      } else {
        // found the node need to be insert in the prev list
        // then find the place need to insert it need to start from the head

        // define the node need to be inserted
        ListNode insertedNode = current.next;
        current.next = current.next.next;
        prev = dummy;
        while (prev.next.val < insertedNode.val) {
          prev = prev.next;
        }
        // update direction and insert the insertedNode to right position
        insertedNode.next = prev.next;
        prev.next = insertedNode;
      }
    }
    return dummy.next;
  }
}
