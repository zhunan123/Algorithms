package ShoulderU.TwoPointer.aug10;

import ShoulderU.RecursionTree.june18.ListNode;

public class LinkedListCycleII142 {
  public ListNode detectCycle(ListNode head) {
    // first step fine the intesaction point use two pointer, then have 2 pointer, start from head and intersaction, move 1 node at a time, when they meet in same node, return it that is start of the circle
    if (head == null || head.next == null) {
      return null;
    }

    ListNode intersact = intersaction(head);
    if (intersact == null) {
      return null;
    }

    // start from head and intersaction and keep iterate, return meeting point
    // while head != intersact keep going
    ListNode start = head;
    while (start != intersact) {
      intersact = intersact.next;
      start = start.next;
    }
    return start;
  }

  private ListNode intersaction(ListNode head) {
    if (head == null || head.next == null) {
      return null;
    }
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      // this line is wield why first declear and fast then make if condition?
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        return slow;
      }
    }
    return null;
  }
}
