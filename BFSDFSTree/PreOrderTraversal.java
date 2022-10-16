package BFSDFSTree;

public class PreOrderTraversal {
    /**
     * 输入：
     * 二叉树 = {1,2,3}
     * 输出：
     * [1,2,3]
     * 解释：
     *       1
     *     /   \
     *   2       3
     * */

    public List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    public void preOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preOrder(root.left, res);
        preOrder(root.right, res);
    }
}
