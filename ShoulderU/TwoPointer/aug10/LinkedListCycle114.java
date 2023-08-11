package ShoulderU.TwoPointer.aug10;

import ShoulderU.RecursionTree.june18.ListNode;

public class LinkedListCycle114 {
  public boolean hasCycle(ListNode head) {
    // idea: two pointer, have slow pointer at head, fast pointer at head.next, everytime slow move 1 nodes, fast move 2 nodes, if slow == fast means theres a circle
    if (head == null) {
      return false;
    }
    ListNode slow = head;
    ListNode fast = head.next;

    while (fast != null && fast.next != null) {
      // 如果在相同node遇见，那就说明有circle
      if (slow == fast) {
        return true;
      }
      slow = slow.next;
      fast = fast.next.next;
    }
    return false;
  }
}
