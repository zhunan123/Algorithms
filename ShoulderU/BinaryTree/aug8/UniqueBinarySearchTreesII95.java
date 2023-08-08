package ShoulderU.BinaryTree.aug8;

import ShoulderU.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII95 {
  public List<TreeNode> generateTrees(int n) {
    // 用123的第二个来代入
    if (n == 0) {
      return new ArrayList<>();
    }
    return helper(1, n);
  }

  public List<TreeNode> helper(int start, int end) {
    List<TreeNode> list = new ArrayList<>();
    if (start > end) {
      list.add(null);
      return list;
    }

    for (int i = start; i <= end; i++) {
      List<TreeNode> leftNodes = helper(start, i - 1);
      List<TreeNode> rightNodes = helper(i + 1, end);
      for (TreeNode left : leftNodes) {
        for (TreeNode right : rightNodes) {
          TreeNode root = new TreeNode(i);
          root.left = left;
          root.right = right;
          list.add(root);
        }
      }
    }
    return list;
  }
}
