package ShoulderU.BinaryTree.aug15;

import ShoulderU.BinaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreePostorderTraversal145 {
  // Recursive DFS
   public List<Integer> postorderTraversal(TreeNode root) {
       List<Integer> list = new ArrayList<>();
       if (root == null) {
           return list;
       }
       helper(root, list);
       return list;
   }

   private void helper(TreeNode root, List<Integer> list) {
       if (root != null) {
           helper(root.left, list);
           helper(root.right, list);
           list.add(root.val);
       }
   }

  /**
   3
   / \
   2   4
   /
   1

   list 2, 1, 4, 3
   queue
   both of dfs and bfs have time complexity of O(N)
   */
  //BFS
  //first in arraydeque is like top of stack addFirst is like push to top in stackm removeFirst is like pop() top in stack
  public List<Integer> postorderTraversal2(TreeNode root) {
    Deque<TreeNode> stack = new ArrayDeque<>();
    List<Integer> list = new ArrayList<>();

    if (root == null) {
      return list;
    }

    stack.addFirst(root);

    while (!stack.isEmpty()) {
      TreeNode current = stack.removeFirst();
      list.add(0, current.val);

      if (current.left != null) {
        stack.addFirst(current.left);
      }
      if (current.right != null) {
        stack.addFirst(current.right);
      }
    }

    return list;
  }
}
