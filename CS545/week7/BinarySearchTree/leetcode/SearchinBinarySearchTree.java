package CS545.week7.BinarySearchTree.leetcode;

public class SearchinBinarySearchTree {

  /**
   * You are given the root of a binary search tree (BST) and an integer val.
   *
   * Find the node in the BST that the node's value equals val and return the subtree rooted with that node.
   * If such a node does not exist, return null.*
   *
   * Example 1:
   *
   *
   * Input: root = [4,2
   * */

  public TreeNode searchBST(TreeNode root, int val) {
    if (root == null) {
      return null;
    }

    while (root != null) {
      if (root.val == val) {
        return root;
      } else if (val < root.val) {
        root = root.left;
      } else {
        root = root.right;
      }
    }
    return null;
  }
}
