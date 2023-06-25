package ShoulderU.BFSDFS.june23;

import BFSDFSTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class FindLargestValueinEachTreeRow515 {
  public List<Integer> largestValues(TreeNode root) {
    // handle edge case
    if (root == null) {
      return new ArrayList<>();
    }
    List<Integer> ans = new ArrayList<>();
    ArrayDeque<TreeNode> queue = new ArrayDeque<>();
    queue.addLast(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      int max = Integer.MIN_VALUE;
      for (int i = 0; i < size; i++) {
        TreeNode current = queue.poll();
        if (current.val > max) {
          max = current.val;
        }
        // add children into queue
        if (current.left != null) {
          queue.add(current.left);
        }
        if (current.right != null) {
          queue.add(current.right);
        }
      }
      ans.add(max);
    }
    return ans;
  }
}
