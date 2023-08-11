package ShoulderU.TwoPointer.aug10;

import ShoulderU.RecursionTree.june18.ListNode;

public class ReorderList143 {
  public void reorderList(ListNode head) {
    // 分三步，找到中点，把中点之后的node list翻转一下，然后两个list，从第一个node开始拼接，先中点之前的list第一个，在第二个reverse弄的的第一个
    if (head == null || head.next == null) {
      return;
    }
    //找到中点
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    //reverse after mid point includes it
    ListNode newHead = slow;
    ListNode prev = null;
    while (newHead != null) {
      ListNode next = newHead.next;
      newHead.next = prev;
      prev = newHead;
      newHead = next;
    }
    //merge 2 list
    // list1 start is head, list2 start is prev
    // 1->2 /////. 5->4->3
    ListNode first = head;
    ListNode second = prev;
    while (second.next != null) {
      ListNode temp = first.next;
      first.next = second;
      first = temp;

      temp = second.next;
      second.next = first;
      second = temp;
    }
  }
}
