package ShoulderU.BinaryTree.aug15;

import ShoulderU.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal94 {
  public List<Integer> inorderTraversal(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    List<Integer> ans = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    while (true) {
      if (root != null) {
        stack.push(root);
        root = root.left;
      } else {
        if (stack.isEmpty()) {
          break;
        }
        TreeNode popped = stack.pop();
        ans.add(popped.val);
        root = popped.right;
      }
    }
    return ans;
  }
}
