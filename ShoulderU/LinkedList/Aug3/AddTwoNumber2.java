package ShoulderU.LinkedList.Aug3;

public class AddTwoNumber2 {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    // idea: go through each node from beginning, add from both list, if > 10 add 0 and append 1 to next, if one list is empty just add another list and if there is appedns from previous
    // need to define prevnode, currentnode, list1_val, list2_val, currentSum, carry, last_digit, advance list1 node, advance list2 node ,advance current
    // when done with while loop of we have carry > 0 create a new list node of carry value, make current.next = new node, advance current

    ListNode dummy = new ListNode(-1);
    ListNode currentNode = dummy;
    int carry = 0;
    while (l1 != null || l2 != null) {
      int l1_val = l1 == null ? 0 : l1.val;
      int l2_val = l2 == null ? 0 : l2.val;

      int currentSum = l1_val + l2_val + carry;
      carry = currentSum / 10;
      int last_digit = currentSum % 10;
      currentNode.next = new ListNode(last_digit);

      // advance pointer
      if (l1 != null) l1 = l1.next;
      if (l2 != null) l2 = l2.next;
      currentNode = currentNode.next;
    }
    // 900 + 900 = 1800, have reached to end and break while loop, if still have carry need to add that
    if (carry > 0){
      ListNode newNode = new ListNode(carry);
      currentNode.next = newNode;
      currentNode = currentNode.next;
    }

    //return dummy
    return dummy.next;
  }
}
