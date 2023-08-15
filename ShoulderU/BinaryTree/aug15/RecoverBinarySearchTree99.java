package ShoulderU.BinaryTree.aug15;

import ShoulderU.BinaryTree.TreeNode;

public class RecoverBinarySearchTree99 {
  //两步，第一步找错误节点，第二步换错误节点
  //inorder 的话是个单调递增1，2，3，4，5---》
  /**
        2
      /  \
     1     4
          / \
         3   5
   */
  // 比如说他家交换了两个1，4，3，2，5， 然后需要找到4和2，然后进行一个交换，
  // 那如何找到这个点呢，就进行inorder遍历，设置一个prev和current， current 是prev后面一个,prev永远都比current小，
  // 第一次发现问题是在prev这个点，第二次发现问题是在root/current问题点，吧prev存进去first，吧current/root存进去second
  // 找到之后就是交换，数值进行交换就行了

  TreeNode prev = null;
  TreeNode first = null;
  TreeNode second = null;
  public void recoverTree(TreeNode root) {
    if (root == null) {
      return;
    }
    inorder(root);
    int temp = first.val;
    first.val = second.val;
    second.val = temp;
  }

  private void inorder(TreeNode root) {
    if (root == null) {
      return;
    }
    inorder(root.left);
    if (prev != null && root.val <= prev.val) {
      if (first == null) {
        first = prev;
      }
      second = root;
    }
    prev = root;
    inorder(root.right);
  }
}
