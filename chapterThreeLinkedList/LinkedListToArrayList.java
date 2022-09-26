package chapterThreeLinkedList;

import java.util.ArrayList;
import java.util.List;

public class LinkedListToArrayList {
    public List<Integer> toArrayList(ListNode head) {
        List<Integer> alist = new ArrayList<>();
        while(head != null){
            alist.add(head.val);
            head = head.next;
        }
        return alist;
    }
}
