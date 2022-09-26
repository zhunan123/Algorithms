package chapterThreeLinkedList;

import java.util.List;

public class ArrayListToLinkedList {
    public ListNode toLinkedList(List<Integer> nums) {
        // write your code here
        if(nums.isEmpty()){
            return null;
        }
        ListNode prevhead = new ListNode(-1);
        ListNode cur = prevhead;
        for(int i=0;i<nums.size();i++){
            ListNode newNode = new ListNode(nums.get(i));
            cur.next = newNode;
            cur = cur.next;
        }
        return prevhead.next;
    }
}
