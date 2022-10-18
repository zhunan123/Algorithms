package BFSDFSTree;

public class isTweakedTreeIdenticalUsingRecursion {
    public boolean isTweakedIdentical(TreeNode a, TreeNode b) {
        /**
         * 输入：{1,2,3,4}，{1,3,2,#,#,#,4}
         * 输出：true
         * 解释：
         *         1             1
         *        / \           / \
         *       2   3    和   3   2
         *      /                   \
         *     4                     4
         *
         * 是相同的。
         * */
        if(a == null && b == null) {
            return true;
        }
        if(a == null || b == null){
            return false;
        }
        if(a.val != b.val){
            return false;
        }

        return (isTweakedIdentical(a.left, b.left) && isTweakedIdentical(a.right, b.right)) || (isTweakedIdentical(a.left, b.right) && isTweakedIdentical(a.right, b.left));
    }
}
