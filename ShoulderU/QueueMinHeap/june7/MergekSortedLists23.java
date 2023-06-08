package ShoulderU.QueueMinHeap.june7;


import java.util.PriorityQueue;

public class MergekSortedLists23 {

    /**
     * first adding all first listNode of listNode[] into the minheap,then in a while loop while minheap is not empty,
     * then removemin and add to the result linkedlist, add the next node in the linkedlist into the minheap,
     * then just continue popping the smallested and add to the result list. and add  the next linkedlist node to the minheap,
     * if next list node is null, then nothing need ed to be added into the min heap.
     * keep lopping in while loop and will stop until minheap is empty
     * */

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val -  b.val);
        // add each listNode head into the minheap
        for (int i = 0; i < lists.length; i++) {
            ListNode head = lists[i];
            if (head != null) {
                minHeap.offer(head);
            }
        }
        // create a result listNode linedList
        ListNode dummy = new ListNode();// need to have this dummy since prev is updating constantly
        ListNode prev = dummy;

        // create a while loop and if min heap is not empty
        while(!minHeap.isEmpty()) {
            // listNode current = removeMin poll the smallest
            ListNode current = minHeap.poll();
            // add current to listNode LinkedList
            prev.next = current;
            // update prev to next
            prev = prev.next;

            // move to current's next listNode and add to minheap
            if (current.next != null) {
                ListNode next = current.next;
                minHeap.offer(next);
            }
        }
        return dummy.next;
    }
}
