package chapterThreeLinkedList;

public class LinkedListdeleteDuplicatesEnhanced {

    public ListNode deleteDuplicates(ListNode head) {

        /*
        * 1->2->3->3->4->4->5->null
        *
        * 1->2->5->null
        * */
        //思路就是一直cur.next 往后移动指针如果相同的话，知道不同的时候，cur的指针但不动
     ListNode prevhead = new ListNode(-1);
     prevhead.next = head;
     ListNode cur = prevhead;

     while(cur.next !=null && cur.next.next !=null){
         if(cur.next.val == cur.next.next.val){
             int val = cur.next.val;
             while(cur.next !=null && cur.next.val == val){
                 cur.next = cur.next.next;
             }
         }else {
             cur = cur.next;
         }
     }
     return prevhead.next;
    }
}
