package ShoulderU.Array.july8;

import BFSDFSTree.TreeNode;

public class MaximumBinaryTree654 {
  public TreeNode constructMaximumBinaryTree(int[] nums) {
    return buildTree(nums, 0, nums.length - 1);
  }

  public TreeNode buildTree(int[] nums, int low, int high) {
    // find largeset
    if (low > high) {
      return null;
    }

    int maxValIndex = low;
    for (int i = low; i <= high; i++) {
      if (nums[i] > nums[maxValIndex]) {
        maxValIndex = i;
      }
    }

    // build root
    TreeNode root = new TreeNode(nums[maxValIndex]);
    root.left = buildTree(nums, low, maxValIndex - 1);
    root.right = buildTree(nums, maxValIndex + 1, high);
    return root;
  }
}
