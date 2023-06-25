package ShoulderU.BFSDFS.june23;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class NaryTreeLevelOrderTraversal429 {
  public List<List<Integer>> levelOrder(Node root) {
    if (root == null) {
      return new ArrayList<>();
    }
    ArrayDeque<Node> queue = new ArrayDeque<>();
    queue.addLast(root);
    List<List<Integer>> res = new ArrayList<>();

    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> levelList = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        Node current = queue.poll();
        List<Node> childList = current.children;
        // add current polled TreeNode into level list
        levelList.add(current.val);
        // add all children into queue
        for (Node child : childList) {
          queue.addLast(child);
        }
      }
      // add level list into res list
      res.add(levelList);
    }
    return res;
  }
}
