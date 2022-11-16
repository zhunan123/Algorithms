package DivideAndConquor;

public class CheckIfSubtree {
    /**
     * 输入：{1,2,3,#,#,4},{3,4}
     * 输出：true
     * 解释：
     * 下面的例子中 T2 是 T1 的子树：
     *
     *            1                3
     *           / \              /
     *     T1 = 2   3      T2 =  4
     *             /
     *            4
     *输入：{1,2,3,#,#,4},{3,#,4}
     * 输出：false
     * 解释：
     * 下面的例子中 T2 不是 T1 的子树：
     *
     *            1               3
     *           / \               \
     *     T1 = 2   3       T2 =    4
     *             /
     *            4
     *
     * */
    public boolean isSubtree(TreeNode t1, TreeNode t2) {
        // write your code here

        if (t2 == null) {
            return true;
        }
        if (t1 == null) {
            return false;
        }

        if(isEqual(t1, t2)) {
            return true;
        }

        return isSubtree(t1.left, t2) || isSubtree(t1.right, t2);
    }

    public boolean isEqual(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if ((t1 == null && t2 != null) || (t1 != null && t2 == null)) {
            return false;
        }

        if (t1.val != t2.val) {
            return false;
        }

        return isEqual(t1.left, t2.left) && isEqual(t1.right, t2.right);
    }
}
