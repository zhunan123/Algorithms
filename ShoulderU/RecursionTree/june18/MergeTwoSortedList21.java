package ShoulderU.RecursionTree.june18;

import ShoulderU.RecursionTree.june18.ListNode;

public class MergeTwoSortedList21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // create prehead and set current to prehea
        ListNode prevhead = new ListNode(-1);
        ListNode current = prevhead;

        // start the while loop
        while (list1 != null || list2 != null) { // in while loop chech if one of the list or both list is not null, means still have nodes
            if (list1 == null) { // if list1 is null, continue add node from list2, update current; update list2
                current.next = list2;
                list2 = list2.next;
                current = current.next;
            } else if (list2 == null) { // if list2 is mull, continue add node from list1, update current, update list1
                current.next = list1;
                list1 = list1.next;
                current = current.next;
            } else {
                // general case, 2 list are not null
                if (list2.val >= list1.val) { // list2 >= list1, add list1 to current
                    current.next = list1;
                    list1 = list1.next;
                } else { // list2 < list1, add list1 to current
                    current.next = list2;
                    list2 = list2.next;
                }
                // update current
                current = current.next;
            }
        }
        return prevhead.next;
    }
}
