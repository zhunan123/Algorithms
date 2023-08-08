package ShoulderU.BinaryTree.aug8;

import ShoulderU.BinaryTree.TreeNode;

public class SameTree100 {
  public boolean isSameTree(TreeNode p, TreeNode q) {
    return helper(p, q);
  }

  public boolean helper(TreeNode left, TreeNode right) {
    if (left == null && right == null) {
      return true;
    }

    if (left == null || right == null) {
      return false;
    }

    if (left.val != right.val) {
      return false;
    }

    return helper(left.left, right.left) && helper(left.right, right.right);
  }
}
