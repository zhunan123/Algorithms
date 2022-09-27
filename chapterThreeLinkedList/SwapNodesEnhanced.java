package chapterThreeLinkedList;

public class SwapNodesEnhanced {

    public ListNode swapNodes(ListNode head, int v1, int v2) {
        // write your code here
        if(head == null){
            return head;
        }
        ListNode prevhead = new ListNode(-1);
        prevhead.next = head;
        ListNode p1 = prevhead;
        ListNode p2 = prevhead;

        while(p1.next !=null && p1.next.val != v1){
            p1 = p1.next;
        }
        while(p2.next !=null && p2.next.val != v2){
            p2 = p2.next;
        }

        //如果循环完linked list找不到v1 或者v2 直接return head
        if(p1.next == null || p2.next == null){
            return head;
        }

        //这个转的算法nb，画一个图就一清二楚了
        ListNode node1 = p1.next;
        ListNode node2 = p2.next;
        p1.next = p2.next;
        p2.next = node1;
        ListNode temp = node1.next;
        node1.next = node2.next;
        node2.next = temp;


        return prevhead.next;
    }
}
