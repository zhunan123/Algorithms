package ShoulderU.LinkedList.Aug3;

public class SwapNodesinPairs24 {
  public ListNode swapPairs(ListNode head) {
    // idea: have a current node, current.next node and current.next.next node, this current is initially prevhead node we created, then just swap current next node with current next next node till the end

    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode current = dummy;
    while (current.next != null && current.next.next != null) {
      ListNode firstNode = current.next;
      ListNode secondNode = current.next.next;
      firstNode.next = secondNode.next;
      current.next = secondNode;
      secondNode.next = firstNode;
      current = current.next.next;
    }
    return dummy.next;
  }
}
