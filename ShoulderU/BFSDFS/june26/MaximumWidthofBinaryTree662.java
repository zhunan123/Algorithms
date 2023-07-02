package ShoulderU.BFSDFS.june26;

import BFSDFSTree.TreeNode;

import java.util.ArrayDeque;

public class MaximumWidthofBinaryTree662 {
  public int widthOfBinaryTree(TreeNode root) {
    // idea: for each level we find the maxium width, then compare the maxium width and finally return it.
    ArrayDeque<TreeNode> queue = new ArrayDeque<>();
    int maxWidth = Integer.MIN_VALUE;
    queue.add(root);
    while(!queue.isEmpty()) {
      int size = queue.size();
      // create a list
      int[] list = new int[size];
      for (int i = 0; i < size; i++) {
        TreeNode current = queue.poll();
        // add to list if not null
        if (current.val == 0) {
          list[i] = 0;
          // if we have a null node we still need to add children to queue as well
          queue.add(new TreeNode(0));
          queue.add(new TreeNode(0));
        } else {
          list[i] = 1;
          // in this case we need to add current left and current right if has null value
          if (current.left == null) {
            queue.add(new TreeNode(0));
          } else {
            queue.add(current.left);
          }
          if (current.right == null) {
            queue.add(new TreeNode(0));
          } else {
            queue.add(current.right);
          }
        }
      }
      //check if all list value if 0, then break
      int sum = 0;
      for (int i = 0; i < list.length; i++) {
        if (list[i] == 1) {
          sum++;
        }
      }
      if (sum == 0) {
        break;
      }
      // check list first 1 and last 1 and calculate the width
      int i = 0, j = list.length - 1;
      while (i < j) {
        if (list[i] == 1 && list[j] == 1) {
          break;
        }
        if (list[i] != 1) {
          i++;
        }
        if (list[j] != 1) {
          j--;
        }
      }
      int currentWidth = j - i + 1;
      if (currentWidth > maxWidth) {
        maxWidth = currentWidth;
      }
    }
    return maxWidth;
  }


  public int widthOfBinaryTree2(TreeNode root) {
    if (root == null) {
      return 0;
    }
    // idea: for each level we find the maxium width, then compare the maxium width and finally return it.
    ArrayDeque<TreeNode> queue = new ArrayDeque<>();
    int maxWidth = Integer.MIN_VALUE;
    queue.add(root);
    outerLoop: while(!queue.isEmpty()) {
      int size = queue.size();
      // create a list
      int[] list = new int[size];
      for (int i = 0; i < size; i++) {
        TreeNode current = queue.poll();
        // add to list if not null
        if (current.val == -101) {
          list[i] = 0;
          // if we have a null node we still need to add children to queue as well
          queue.add(new TreeNode(-101));
          queue.add(new TreeNode(-101));
        } else {
          list[i] = 1;
          // in this case we need to add current left and current right if has null value
          if (current.left == null) {
            queue.add(new TreeNode(-101));
          } else {
            queue.add(current.left);
          }
          if (current.right == null) {
            queue.add(new TreeNode(-101));
          } else {
            queue.add(current.right);
          }
        }
      }
      //check if all list value is -101, then break
      for (int i = 0; i < list.length; i++) {
        if (list[i] != -101) {
          break;
        }
        if (i == list.length - 1 && list[i] == -101){
          break outerLoop;
        }
      }
      // check list first 1 and last 1 and calculate the width
      int i = 0, j = list.length - 1;
      while (i < j) {
        if (list[i] == 1 && list[j] == 1) {
          break;
        }
        if (list[i] != 1) {
          i++;
        }
        if (list[j] != 1) {
          j--;
        }
      }
      int currentWidth = j - i + 1;
      if (currentWidth > maxWidth) {
        maxWidth = currentWidth;
      }
    }
    return maxWidth;
  }
}
