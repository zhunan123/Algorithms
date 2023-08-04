package ShoulderU.LinkedList.Aug3;

import java.util.PriorityQueue;

public class MergeKSortedListed23 {
  public ListNode mergeKLists(ListNode[] lists) {
    // idea: add each linkedlist head in to minHeaap first, si 1,1,2 in heap first, then initialize the linkedlist and then then poll heap top and add to linkedlist, so poll 1 in the first linkedlist, then add 4 into the minheap, so if the polled node have next then add next node into the minheap

    PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
    // only add first node in each list into heap for now
    for (int i = 0; i < lists.length; i++) {
      ListNode head = lists[i];
      if (head != null) {
        heap.add(head);
      }
    }
    ListNode prev = new ListNode(-1);
    ListNode current = prev;
    while (!heap.isEmpty()) {
      ListNode node = heap.poll();
      current.next = node;
      current = current.next;

      if (current.next != null) {
        heap.add(current.next);
      }
    }
    return prev.next;
  }
}
