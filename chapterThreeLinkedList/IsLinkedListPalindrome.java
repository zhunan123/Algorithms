package chapterThreeLinkedList;

import java.util.ArrayList;

public class IsLinkedListPalindrome {
    public boolean isPalindrome(ListNode head) {
        // write your code here
        /*
        * 输入: 1->2->1
        * 输出: true
        * */

        ArrayList<Integer> alist = new ArrayList<Integer>();
        ListNode cur = head;
        while (cur != null){
            alist.add(cur.val);
            cur = cur.next;
        }

        int front = 0;
        int back = alist.size() -1;
        while(front < back){
            if(!alist.get(front).equals(alist.get(back))){
                return false;
            }
            front++;
            back--;

        }
        return true;
    }
}
