package ShoulderU.BinaryTree.aug8;

import ShoulderU.BinaryTree.TreeNode;

import java.util.HashMap;

public class ConstructBinaryTreefromPreorderandInorderTraversal105 {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    // idea: preorder 第一个肯定是跟节点，在indorder数组里面找到root的位置，会发现inorder array里面 (拿到左子树和右子树范围)，跟节点左边的数组都是左节点，右边的数组都是右节点。在返回preorder数组，吧preorder根据根左右进行划分.
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }

    return helper(preorder, inorder, 0, 0, inorder.length - 1, map);
  }

  public TreeNode helper(int[]preorder, int[] inorder, int preStart, int inStart, int inEnd, HashMap<Integer, Integer> map) {
    //edge case
    if (preStart >= preorder.length || inStart > inEnd) {
      return null;
    }
    // find root and rootInde
    TreeNode root = new TreeNode(preorder[preStart]);
    int rootIndex = map.get(preorder[preStart]);
    //recursive return
    root.left = helper(preorder, inorder, preStart + 1, inStart, rootIndex - 1, map);
    root.right = helper(preorder, inorder, preStart + rootIndex - inStart + 1, rootIndex + 1, inEnd, map);
    return root;
  }
}
