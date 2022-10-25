package BFSDFSTree;

public class BinarySearchTreeCheckIsBalancedTreeUsingRecursion {
    /**
     * 二叉搜索树：它或者是一棵空树，或者是具有下列性质的二叉树：
     * 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值； 若它的右子树不空
     *，则右子树上所有结点的值均大于它的根结点的值； 它的左、右子树也分别为二叉排序树。
     * 平衡二叉树：给定一个二叉树,确定它是高度平衡的。对于这个问题,一棵高度平衡的二叉树的定义是：一棵二叉树中每个节点的两个子树的深度相差不会超过1。
     * 输入：
     * tree = {1,2,3}
     * 输出：
     * true
     * 解释：
     * 如下，是一个平衡的二叉树。
     *           1
     *          / \
     *         2   3
     * */

    public boolean isBalanced(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        } else {
            return Math.abs(TreeHeight(root.left) - TreeHeight(root.right)) <=1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public int TreeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(TreeHeight(root.left), TreeHeight(root.right)) + 1;
        }
    }
}