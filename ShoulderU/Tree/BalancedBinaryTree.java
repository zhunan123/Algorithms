package ShoulderU.Tree;

public class BalancedBinaryTree {

  /**
   * Given a binary tree, determine if it is
   * height-balanced --> when the height of left tree and height of right tree have difference <= 1
   *
   * Example 1:
   *
   *
   * Input: root = [3,9,20,null,null,15,7]
   * Output: true
   * */

  /**
   * need to have a computeHeight function is this computeHeight is -1 means not balanced.
   * then in the compute Height function, seperately compute left height of a node and right height of a nodes compare the height if > 1 return -1
   * in this compute height function is just like height function in BST
   * */

  public int computeHeight(TreeNode root) {
    //base case
    if (root == null) {
      return 0;
    }

    int leftHeight = computeHeight(root.left);
    int rightHeight = computeHeight(root.right);


    //break condition is either left or right is unbalanced tree,
    // even though they can be have height diff <= 1 but they are still unbalanced tree, return -1
    //difference bettwen left height and right height is greater than 1 return -1

    //Compute left tree height 和rigjt tree height之后三个情况
    //if left tree height = -1 or right tree height = -1 or math abs 2 hight>1 return -1
    if (leftHeight == -1 || rightHeight == -1) {
      return -1;
    }
    if (Math.abs(leftHeight - rightHeight) >  1) {
      return -1;
    }

    //recursive case
    int height = Math.max(leftHeight,rightHeight) + 1;
    return height;
  }

  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }

    if (computeHeight(root) == -1) {
      return false;
    }

    return true;
  }
}
