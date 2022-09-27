package chapterThreeLinkedList;

import java.util.ArrayList;

public class LinkedListDeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        // write your code here

        if(head == null) {
            return head;
        }

        ArrayList<Integer> alist = new ArrayList<Integer>();
        alist.add(head.val);
        ListNode cur = head;
        while(cur.next != null){
            if(!alist.contains(cur.next.val)){
                alist.add(cur.next.val);
                cur = cur.next;
            }else {
                cur.next = cur.next.next;
            }
        }
        return head;
    }
}
