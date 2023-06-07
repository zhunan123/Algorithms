package ShoulderU.Stack.june5;


import java.util.Stack;

public class MaximumTwinSumofaLinkedList2130 {

  public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public int pairSum(ListNode head) {
        // 这个配对 一定是第一个跟最后一个配对，然后第二个跟倒数第二个配对，找对大的sum但是是在linkedlist里面找

        // first create stack, and add every element's val into stack
        Stack<Integer> stack  = new Stack<>();
        ListNode current = head;
        while (current != null) {
            stack.push(current.val);
            current = current.next;
        }

        // start calculate sum, add first value from 0 to stack.size() / 2 - 1 with stack pop. then keep track the largest.
        int sum = 0; // initialize sum
        current = head;
        int currentIndex = 0; // define current ListNode index
        // start while loop and only consider index i to stack.size() / 2 - 1, becuase after that, there will be no pair
        int n = stack.size(); // we can have this constant n, and increament currIndex later on.
        while (currentIndex <= n / 2 - 1) { // its better not to make stack.size(), because stack.size() is changing when we pop stack, instead we can have constant n
            // then we calculate the sum, compare previous sum with currentsum
            // current sum is calculate based on current node list value + stack top val
            int currentSum = current.val + stack.pop();
            sum = Math.max(sum, currentSum);
            current = current.next;
            currentIndex++;
        }

        //return sum
        return sum;
    }
}
