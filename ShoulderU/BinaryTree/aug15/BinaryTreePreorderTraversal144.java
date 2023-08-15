package ShoulderU.BinaryTree.aug15;

import ShoulderU.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal144 {
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    if (root != null) {
      stack.push(root);
      while (!stack.isEmpty()) {
        TreeNode popped = stack.pop();
        ans.add(popped.val);
        if (popped.right != null) {
          stack.push(popped.right);
        }
        if (popped.left != null) {
          stack.push(popped.left);
        }
      }
    }
    return ans;
  }
}
