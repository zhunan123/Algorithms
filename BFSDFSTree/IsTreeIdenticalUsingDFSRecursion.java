package BFSDFSTree;

public class IsTreeIdenticalUsingDFSRecursion {

    /**
     * 输入：{1,2,2,4}，{1,2,2,4}
     * 输出：true
     * 解释：
     *         1                   1
     *        / \                 / \
     *       2   2   和          2   2
     *      /                   /
     *     4                   4
     *
     * 是相同的。
     * */
    public boolean isIdentical(TreeNode a, TreeNode b) {
        // write your code here

        if (a == null & b == null) {
            return true;
        } else if (a == null || b == null) {
            return false;
        } else if (a.val != b.val){
            return false;
        } else {
            return isIdentical(a.left, b.left) && isIdentical(a.right, b.right);
        }
    }
}