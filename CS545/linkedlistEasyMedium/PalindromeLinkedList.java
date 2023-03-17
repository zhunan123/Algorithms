package CS545.linkedlistEasyMedium;

public class PalindromeLinkedList {

  /**
   * Given the head of a singly linked list, return true if it is a
   * palindrome
   *  or false otherwise.
   *
   *
   * Example 1:
   *
   *
   * Input: head = [1,2,2,1]
   * Output: true
   * Example 2:
   *
   *
   * Input: head = [1,1,2,1]
   * Output: false
   * */


  public boolean isPalindrome(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    //for reverse the second halves purpose
    ListNode prev = null;


    //find mid point
    while (fast.next != null && fast.next.next != null){
      fast = fast.next.next;
      slow = slow.next;
    }

    //reverse the second halves
    ListNode curr = slow.next;
    while (curr != null) {
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }

    //compare first halves with second half
    //prev is the new head
    ListNode head1 = head;
    ListNode head2 = prev;

    //head2 will have greater size than head1 since it has null at end,
    // so only need to declear head2 != null will compare the full first halves and second halves
    while (head2 != null) { //this is most important part
      if (head1.val != head2.val) {
        return false;
      }
      head1 = head1.next;
      head2 = head2.next;
    }

    return true;
  }
}
