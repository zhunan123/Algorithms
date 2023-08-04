package ShoulderU.LinkedList.Aug3;

public class MergeTwoSortedLists21 {
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode prevHead = new ListNode(-1);
    ListNode current = prevHead;

    while (list1 != null || list2 != null) {
      if (list1 == null) {
        current.next = new ListNode(list2.val);
        list2 = list2.next;
        current = current.next;
      } else if (list2 == null) {
        current.next = new ListNode(list1.val);
        list1 = list1.next;
        current = current.next;
      } else {
        if (list1.val > list2.val) {
          current.next = new ListNode(list2.val);
          list2 = list2.next;
        } else {
          current.next = new ListNode(list1.val);
          list1 = list1.next;
        }
        current = current.next;
      }
    }
    return prevHead.next;
  }
}
