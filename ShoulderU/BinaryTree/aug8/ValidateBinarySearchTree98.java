package ShoulderU.BinaryTree.aug8;

import ShoulderU.BinaryTree.TreeNode;

public class ValidateBinarySearchTree98 {
  public boolean isValidBST(TreeNode root) {
    return helper(root, null, null);
  }

  public boolean helper(TreeNode root, Integer low, Integer high) {
    if (root == null) {
      return true;
    }

    // high is left handside, low is righthand side
    if ((high != null && root.val >= high) || (low != null && root.val <= low)) {
      return false;
    }

    return helper(root.left, low, root.val) && helper(root.right, root.val, high);
  }
}
