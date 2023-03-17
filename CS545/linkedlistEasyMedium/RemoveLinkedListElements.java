package CS545.linkedlistEasyMedium;

public class RemoveLinkedListElements {

  /**
   * Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
   *
   *
   *
   * Example 1:
   *
   *
   * Input: head = [1,2,6,3,4,5,6], val = 6
   * Output: [1,2,3,4,5]
   * Example 2:
   *
   * Input: head = [], val = 1
   * Output: []
   * Example 3:
   *
   * Input: head = [7,7,7,7], val = 7
   * Output: []
   * */

  /**
   * if (找到elem){
   *   prev.next = curr.next
   * } else {
   *   //没找到elem
   *   advance prev = curr
   * }
   * advance curr
   *
   *
   * [1,2,6,6,4,5,6],
   * */
  public ListNode removeElements(ListNode head, int val) {
    ListNode curr = head;
    ListNode start = new ListNode(-1);
    ListNode prev = start;
    prev.next = head;

    while (curr != null) {
      if (curr.val == val) {
        prev.next = curr.next;
      } else {
        //dont update prev unless curr.val  != val, so codition like [7,7,7,7] will delete all 7
        //prev 指针不能动，要判定每一个cur,只有curr不是 target, 才会一定prev
        prev = curr;
      }

      curr = curr.next;
    }
    return start.next;
  }

}
