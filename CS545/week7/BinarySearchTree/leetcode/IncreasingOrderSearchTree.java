package CS545.week7.BinarySearchTree.leetcode;

public class IncreasingOrderSearchTree {

  /**
   * Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node
   * in the tree is now the root of the tree, and every node has no left child and only one right child.
   *
   * Example 1:
   *
   *
   * Input: root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
   * Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
   * */

  TreeNode head = null;
  TreeNode current = null;
  public TreeNode increasingBST(TreeNode root) {
    if (root == null) {
      return null;
    }

    if (root != null) {
      increasingBST(root.left);
      if (current == null) {
        current = new TreeNode(root.val);
        head = current;
      } else {
        current.right = new TreeNode(root.val);
        current = current.right;
      }
      increasingBST(root.right);
    }
    return head;
  }
}
