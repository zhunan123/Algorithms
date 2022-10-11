package QueueStack;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingTwoQueueBasedOnLinkedListClass {

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    //Queue 属于LinkedList class
    //q1 store data after operation, q2 is helper method to help adding the first 入队 element.

    /**
     * 解题思路：
     * 创立两个queue，queue1store data ,q1 magage the new data
     * 最开始q2为空，offer 新的data
     * while q1不为空，把q1所有的data加入q2
     * q1 q2交换， q1store data q1队头就是栈顶 q2为空
     * 重新加入新的data进入q2
     * 在q1 因为stored data 进行poll peek操作
     * */
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    public void push(int x) {
        q2.offer(x);
        while(!q1.isEmpty()){
            q2.offer(q1.poll());
        }
        //交换后q1就是queue with update data, q2就变成了空集，然后可以重新入队
        //q1就可以进行出栈 和top/pop, 因为q1队头就是栈最上面
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        return q1.poll();
    }

    public int top() {
        return q1.peek();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }
}
