package ShoulderU.BinaryTree.aug9;

import ShoulderU.BinaryTree.TreeNode;
import ShoulderU.RecursionTree.june18.ListNode;

public class ConvertSortedListtoBinarySearchTree109 {
  public TreeNode sortedListToBST(ListNode head) {
    //idea 用linkedlist 的方法，就用fast 和 slow来寻找mid point in linkedlist
    return helper(head, null);
  }

  private TreeNode helper(ListNode start, ListNode end) {
    if (start == end) {
      return null;
    }
    ListNode fast = start;
    ListNode slow = start;
    while (fast != end && fast.next != end) {
      fast = fast.next.next;
      slow = slow.next;
    }
    // build tree
    TreeNode root = new TreeNode(slow.val);
    root.left = helper(start, slow);
    root.right = helper(slow.next, end);
    return root;
  }
}
