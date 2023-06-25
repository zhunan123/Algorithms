package ShoulderU.BFSDFS.june23;

import BFSDFSTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseOddLevelsofBinaryTree2415 {
  public TreeNode reverseOddLevels(TreeNode root) {
    // 感觉是一个deep copy还是reference copy的问题
    //思路：create queue，同时要一个level，然后把root加到queue里面，while queue not empty，for int i -> queue size 每一层， 创建一个treeNode array
    // 然后每一个treeNode Array里面放的都是该level所有的treeNode
    // poll queue, 放到treeNodeArray里，然后if polled left and polled right not null 就加到queue里
    // key：level 是odd就要吧刚才treeNode array 里面的treeNOde reverse一下
    // 然后通过 reference copy同时真正的树里面的数值也会更新

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int level = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      // create TreeNode array---- this is the key
      TreeNode[] treeNodeArray = new TreeNode[size];
      for (int i = 0; i < size; i++) {
        // add polled into treeNodeArray, by the end of for loop we will have all treeNode in the same level being stored in the treeNodeArray
        treeNodeArray[i] = queue.poll();
        // add left and right child into queue
        if (treeNodeArray[i].left != null) {
          queue.add(treeNodeArray[i].left);
        }
        if (treeNodeArray[i].right != null) {
          queue.add(treeNodeArray[i].right);
        }
      }
      // check current level
      if (level % 2 == 1) {
        // reverse the treeNodeArray, abd the value will update as well into BST
        reverseArr(treeNodeArray);
      }
      // update level
      level++;
    }
    return root;
  }

  public void reverseArr(TreeNode[] arr) {
    // reverse the treeNdoeArray
    int start = 0;
    int end = arr.length - 1;
    int temp;
    while (start < end) {
      temp = arr[start].val;
      arr[start].val = arr[end].val;
      arr[end].val = temp;

      start++;
      end--;
    }
  }
}
