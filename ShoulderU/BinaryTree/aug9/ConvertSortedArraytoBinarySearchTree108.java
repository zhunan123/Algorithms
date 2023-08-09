package ShoulderU.BinaryTree.aug9;

import ShoulderU.BinaryTree.TreeNode;

public class ConvertSortedArraytoBinarySearchTree108 {
  public TreeNode sortedArrayToBST(int[] nums) {
    // idea: 拿出中间的点档root，然后开始递归，中间点左边的就是左子树，中间点右边的肯定是右子树，然后循环递归就行
    return helper(nums, 0, nums.length - 1);
  }

  private TreeNode helper(int[] nums, int start, int end) {
    if (start > end) {
      return null;
    }
    int mid = start + (end - start) / 2;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = helper(nums, start, mid - 1);
    root.right = helper(nums, mid + 1, end);
    return root;
  }
}
