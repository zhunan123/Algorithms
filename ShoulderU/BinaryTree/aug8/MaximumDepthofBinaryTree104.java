package ShoulderU.BinaryTree.aug8;

import ShoulderU.BinaryTree.TreeNode;

public class MaximumDepthofBinaryTree104 {
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int height = Math.max(maxDepth(root.left), maxDepth(root.right));

    return height + 1;
  }
}
