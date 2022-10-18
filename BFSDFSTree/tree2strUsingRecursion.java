package BFSDFSTree;

public class tree2strUsingRecursion {

    /**
     * 输入: Binary tree: [1,2,3,#,4]
     *        1
     *      /   \
     *     2     3
     *      \
     *       4
     *
     * 输出: "1(2()(4))(3)"
     *
     * 解释: 几乎和第一个样例相同,
     * 除了我们不能忽略第一个括号对，否则将会破坏输入和输出之间的一对一映射关系。
     * */

    public String tree2str(TreeNode t) {
        String s = String.valueOf(t.val);
        boolean hasLeft = false;

        if (t.left != null) {
            hasLeft = true;
            s += "(" + tree2str(t.left) + ")";
        }

        if (t.right != null) {
            if(!hasLeft) {
                s += "()";
            }
            s += "(" + tree2str(t.right) + ")";
        }

        return s;
    }
}
