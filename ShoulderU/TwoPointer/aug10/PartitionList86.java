package ShoulderU.TwoPointer.aug10;

import ShoulderU.RecursionTree.june18.ListNode;

public class PartitionList86 {
  public ListNode partition(ListNode head, int x) {
    // idea： using 2 pointer, put all number < x into a new linkedlist, put all number > x into a new linkedlist then just connect them
    ListNode beforeHead = new ListNode(-1);
    ListNode before = beforeHead;
    ListNode afterHead = new ListNode(-1);
    ListNode after = afterHead;
    while (head != null) {
      if (head.val < x) {
        before.next = head;
        before = before.next;
      } else {
        after.next = head;
        after = after.next;
      }
      head = head.next;
    }
    after.next = null;
    before.next = afterHead.next;
    return beforeHead.next;
  }
}
