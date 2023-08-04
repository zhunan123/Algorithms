package ShoulderU.LinkedList.Aug4;

import ShoulderU.LinkedList.Aug3.ListNode;

public class RotateList61 {
    public ListNode rotateRight(ListNode head, int k) {
        // https://www.youtube.com/watch?v=CABz3Nd64KQ&ab_channel=%E8%B4%BE%E8%80%83%E5%8D%9A
        // 旋转k=2的话，第一步就是吧最后一个拿到第一个，第二步的话继续吧最后一个拿到第一个
        //idea: edge case，得到linkedlist有多长，make index = head, then index will be tail， then after while loop, make this index.next = head(把整个list都传在一块了), 重点 找到head(其实是找到prevhead，make result = prevhead..next, then prevhead.next = null), 把head的prev的线去掉就可以了
        // head = [0,1,2], k = 4 prevhead就是1，然后把1跟2之间的link线给断了
        if (head == null || head.next == null) {
            return head;
        }

        ListNode currIndex = head;
        int length = 1;
        while (currIndex.next != null) {
            currIndex = currIndex.next;
            length++;
        }

        currIndex.next = head;
        //找prevhead，断线
        for (int i = 1; i < length - k % length; i++) { // % 用来k>length
            head = head.next; //这里head就是prevhead
        }
        // 其实真正的head是prevhead.next
        ListNode result = head.next;
        //断线from prevhead 到head
        head.next = null;

        return result;
    }
}
