package CS603.Week2;

import java.util.PriorityQueue;

public class MergeKList23 {
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode prev = new ListNode(-1);
        ListNode current = prev;

//        for (ListNode list : lists) {
//            ListNode head = list;
//            if (head != null) {
//                minHeap.add(head);
//            }
//        }

        for (int i = 0; i < lists.length; i++) {
            ListNode head = lists[i];
            if (head != null) {
                minHeap.add(head);
            }
        }

        while (!minHeap.isEmpty()) {
            ListNode smallest = minHeap.poll();
            current.next = smallest;
            current = current.next;

            if (smallest.next != null) {
                minHeap.add(smallest.next);
            }
        }

        return prev.next;
    }
}
