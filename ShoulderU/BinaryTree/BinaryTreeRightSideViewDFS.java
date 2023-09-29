package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideViewDFS {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    List<Integer> ans = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return ans;
        }
        int level = 0;
        dfs(root, level);
        return ans;
    }

    private void dfs(TreeNode root, int level) {
        if (ans.size() == level){
            ans.add(root.val);
        }
        if (root.right != null) {
            dfs(root.right, level + 1);
        }
        if (root.left != null) {
            dfs(root.left, level + 1);
        }
    }
}
