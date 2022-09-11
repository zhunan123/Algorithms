public class MergeTwoLinkedList {
    /**
     * @param l1: ListNode l1 is the head of the linked list
     * @param l2: ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here/
        /*
        * 输入:  list1 =  dummy->1->3->8->11->15->null, list2 = 2->null
	      输出: 1->2->3->8->11->15->null
        * */

        ListNode prevhead = new ListNode(-1);
        ListNode prev = prevhead;

        while (l1 != null && l2 != null){
            if(l1.val <= l2.val){
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        prev.next = l2 == null ? l1 : l2;

        return prevhead.next;
    }
}
