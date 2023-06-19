package ShoulderU.RecursionTree;

public class PlusOneLinkedList369 {

    // define carry through the help method, take care case when head node with a carry of 1,
    // which will create a new NOde of value 1, inside the helper method,
    // base case is when reached to last digit, evaluate it with carry and return carry to the previous digit,
    // in recursive case, define carry in recursive helper function, evaluate the current digit and return back to previous digit

    public ListNode plusOne(ListNode head) {
        // take care the edge case where in the head node we have a carry of 1
        // define carry
        int carry = calculateCarryWhenPlusOne(head);
        // if head node has val of 9, say example is 99 and carry is 1 we need to handle this edge case
        if (carry == 1) { // if carry is 1
            // create new node if value 1
            ListNode newNode = new ListNode(1);
            newNode.next = head;
            head = newNode;
        }
        return head;
    }

    public int calculateCarryWhenPlusOne(ListNode head) {
        // base case when reach last digit. if + 1 < 10 say 9, head value will be 9 % 10 is 9 and carry will be 9 / 10 which is floor of 0, otherwise 10 / 10 is 1, then carry is 1
        // for example 99 in the helper method we will change to 00 and return to outer function, and outter function will add 1 to it
        if (head.next == null) {
            int newVal = head.val + 1;
            head.val = newVal % 10;
            return newVal / 10;
        }

        // recursive case
        // this will return the previous digit before the last digit
        int carry = calculateCarryWhenPlusOne(head.next);
        // currentDigit the previous digit with carry from last digit
        int currentDigit = head.val + carry; // this is the current digit + carry from next digit
        head.val = currentDigit % 10;
        return currentDigit / 10; // return to previous digit
    }
}
