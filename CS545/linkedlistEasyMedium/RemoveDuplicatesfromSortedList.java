package CS545.linkedlistEasyMedium;

public class RemoveDuplicatesfromSortedList {

  /**
   * Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
   *
   *
   *
   * Example 1:
   *
   *
   * Input: head = [1,1,2]
   * Output: [1,2]
   * Example 2:
   *
   *
   * Input: head = [1,1,2,3,3]
   * Output: [1,2,3]
   * */

  public ListNode deleteDuplicates(ListNode head) {
    ListNode current = head;
    while (current != null) {
      if (current.next == null) {
        break;
      }
      if (current.next.val == current.val) {
        current.next = current.next.next;
      } else { //need else becuase we dont want to advance current if 1 2 2 2 3 4 4 has lots of 2, we need to find 3 then advance
        current = current.next;
      }
    }
    return head;
  }
}
