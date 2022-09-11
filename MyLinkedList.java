import java.util.LinkedList;

public class MyLinkedList {

    private ListNode head;
//    private ListNode dummy = new ListNode(-1);

    //create insert
    public void add(int location, int value){
        if (location > 0){
            ListNode pre = head;
            for(int i = 0; i < location -1; i++){
                pre = pre.next;
            }
            ListNode newNode = new ListNode(value);
            newNode.next = pre.next;
            pre.next = newNode;
        } else {
            ListNode newNode = new ListNode(value);
            newNode.next = head;
            head = newNode;
        }
//        ListNode pre = dummy;
//        for(int i = 0; i < location; i++){
//            pre = pre.next;
//        }
//        ListNode newNode = new ListNode(value);
//        newNode.next = pre.next;
//        pre.next = newNode;
    }

    //get or read value from particular node
    public int get(int location) {
        ListNode cur = head;
//        ListNode cur = dummy.next;
        for(int i = 0; i < location; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    //update node value
    public void update(int location, int newValue){
        ListNode cur = head;
//        ListNode cur = dummy.next;
        for(int i = 0; i < location; i++) {
            cur = cur.next;
        }
        cur.val = newValue;
    }


    //delete return the deleted listnode
    public int remove(int location) {
        ListNode result = null;
        if (location >0){
            ListNode pre = head;
            for(int i=0;i<location -1;i++){
                pre = pre.next;
            }
            result = pre.next;
            pre.next = pre.next.next;
        } else if(location == 0){
            result = head;
            head = head.next;
        }
//        ListNode pre = dummy;
//        for(int i=0;i<location;i++){
//            pre = pre.next;
//        }
//        result = pre.next;
//        pre.next = pre.next.next;

        return result.val;
    }
}
