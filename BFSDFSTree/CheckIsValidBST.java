package BFSDFSTree;

public class CheckIsValidBST {

    /**
     * 给定一个二叉树，判断它是否是合法的二叉查找树(BST)
     * 一棵BST定义为：
     * 节点的左子树中的值要严格小于该节点的值。
     * 节点的右子树中的值要严格大于该节点的值。
     * 左右子树也必须是二叉查找树。
     * 一个节点的树也是二叉查找树。
     * 输入：
     * tree = {2,1,4,#,#,3,5}
     * 输出：
     * true
     * 解释：
     *         二叉树如下：
     *           2
     *          / \
     *         1   4
     *            / \
     *           3   5
     * 这是二叉查找树。
     * */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }
}