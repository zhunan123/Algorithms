package ShoulderU.BinaryTree.aug9;

import ShoulderU.BinaryTree.TreeNode;

import java.util.HashMap;

public class ConstructBinaryTreefromInorderandPostorderTraversal106 {
  // https://www.youtube.com/watch?v=euO5pWQtqNQ&ab_channel=%E8%B4%BE%E8%80%83%E5%8D%9A
  // make start from end of postorder which is root, find this rootindex in inorder, find left and right tree, then for each left and right tree find root and rootindex and further find smaller left and right tree.

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    if (inorder == null || postorder == null || inorder.length != postorder.length){
      return null;
    }

    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < inorder.length; i++){
      map.put(inorder[i], i);
    }

    return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1, map);
  }

  public TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd, HashMap<Integer, Integer> map) {
    // base case
    if (inStart > inEnd || postStart < 0) {
      return null;
    }
    //find rootIndex and root
    TreeNode root = new TreeNode(postorder[postEnd]);
    int rootIndex = map.get(postorder[postEnd]);
    //and left and right then return root
    root.left = helper(inorder, postorder, inStart, rootIndex - 1, postStart, postStart + rootIndex - inStart -1, map);
    root.right = helper(inorder, postorder, rootIndex + 1, inEnd, postStart + rootIndex - inStart, postEnd - 1, map);
    return root;
  }
}
