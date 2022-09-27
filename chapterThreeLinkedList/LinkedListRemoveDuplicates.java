package chapterThreeLinkedList;

import java.util.HashSet;
import java.util.Set;

public class LinkedListRemoveDuplicates {

    public ListNode removeDuplicates(ListNode head) {
        // write your code here
        if(head == null){
            return null;
        }

        Set<Integer> set = new HashSet<Integer>();
        set.add(head.val);
        ListNode cur = head;
        while (cur.next != null) {
            ListNode nxt = cur.next;
            if(!set.contains(nxt.val)) {
                set.add(nxt.val);
                //只有不是重复，cur的指针才会往后移动
                cur = cur.next;
            }else {
                //如果有重复要删除的话 cur的指针就不会往下移
                cur.next = cur.next.next;
            }
        }

        return head;
    }
}
