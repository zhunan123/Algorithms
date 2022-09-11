public class InsertNode {

    public ListNode insertNode(ListNode head, int val) {
        //-1->1->4->6->8  5
        //-1->1->null 2
        // write your code here
        ListNode prehead = new ListNode(-1);
        ListNode newNode = new ListNode(val);
        ListNode prev = prehead;
        prev.next = head;
        ListNode cur = head;

        //insert in location of head
        if(head == null){
            return newNode;
        }

        //insert in middle
        while (cur != null && cur.val < val){
            cur = cur.next;
            prev = prev.next;
        }
        newNode.next = prev.next;
        prev.next = newNode;

        //insert in end
        if(cur == null){
            prev.next = newNode;
        }

        return prehead.next;
    }
}
