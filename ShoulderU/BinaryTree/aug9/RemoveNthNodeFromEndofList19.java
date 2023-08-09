package ShoulderU.BinaryTree.aug9;

import ShoulderU.RecursionTree.june18.ListNode;

public class RemoveNthNodeFromEndofList19 {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    // idea: fast and slow 中间隔了n个element 比如说2， slow start dummy before 1， fast start from 3
    // https://www.youtube.com/watch?v=zSTt-x8JeFI&ab_channel=%E8%B4%BE%E8%80%83%E5%8D%9A

    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode fast = dummy, slow = dummy;

    for (int i = 0; i <= n; i++) {
      fast = fast.next;
    }

    while (fast != null) {
      fast = fast.next;
      slow = slow.next;
    }
    slow.next = slow.next.next;
    return dummy.next;
  }
}
