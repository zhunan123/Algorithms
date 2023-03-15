package CS545.linkedlistEasyMedium;

public class MergeTwoSortedList {

  /**
   * You are given the heads of two sorted linked lists list1 and list2.
   * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
   * Return the head of the merged linked list.
   *
   * Example 1:
   *
   *
   * Input: list1 = [1,2,4], list2 = [1,3,4]
   * Output: [1,1,2,3,4,4]
   * */



  /**  my try is not correct, we already check while loop are checking if either list1 or list2 is null
   * then inside the while loop we cannot check again so we need to check it outside the while loop;
   *
   * public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
   *         ListNode prehead = new ListNode(0);
   *         ListNode curr = prehead;
   *
   *         while (list1 != null && list2 != null) {
   *             if (list1 == null) {
   *                 curr.next = list2;
   *                 list2 = list2.next;
   *             } else if (list2 == null) {
   *                 curr.next = list1;
   *                 list1 = list1.next;
   *             } else {
   *                 if (list1.val > list2.val) {
   *                     curr.next = list2;
   *                     list2 = list2.next;
   *                 } else {
   *                     curr.next = list1;
   *                     list1= list1.next;
   *                 }
   *             }
   *         }
   *
   *         return prehead.next;
   *     }
   * There seems to be an error in the implementation of the mergeTwoLists method.
   * The if statements inside the while loop are checking if either list1 or list2 is null,
   * which is incorrect since the loop condition already checks if both are not null.
   *
   * To merge two sorted linked lists, you need to compare the values of the current nodes of both lists,
   * and add the smaller one to the merged list. You then move the pointer of the smaller list to the next node and
   * repeat the process until one of the lists is empty. Finally, you append the remaining nodes of the non-empty list to the merged list.
   *
   * Here's the corrected implementation:

   * In this implementation, we first create a new linked list with a dummy prehead node.
   * We then use curr to keep track of the last node that was added to the merged list.
   *
   * We then use a while loop to iterate over both lists until one of them is empty.
   * In each iteration, we compare the values of the current nodes of both lists.
   * We add the node with the smaller value to the merged list, and move the pointer of the smaller
   * list to the next node.
   *
   * Finally, after the while loop, we append the remaining nodes of the non-empty list to the merged list. We return the next node of the prehead, which points to the first node of the merged list
   *
   * */


  //iterate the list until one of the list is empty then append the other remaining list.
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode prehead = new ListNode(0);
    ListNode curr = prehead;

    while (list1 != null && list2 != null) {
      if (list1.val > list2.val) {
        curr.next = list2;
        list2 = list2.next;
      } else {
        curr.next = list1;
        list1= list1.next;
      }
      curr = curr.next;
    }

    if (list1 == null) {
      curr.next = list2;
    } else {
      curr.next = list1;
    }

    return prehead.next;
  }
}
