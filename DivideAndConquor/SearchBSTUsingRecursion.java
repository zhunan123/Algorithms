package DivideAndConquor;

public class SearchBSTUsingRecursion {
    /**
     * 样例 1:
     *
     * 输入: value = 2
     *         4
     *        / \
     *       2   7
     *      / \
     *     1   3
     * 输出: 节点 2
     * */

    public TreeNode searchBTS(TreeNode root, int val) {
        if (root.val == val || root == null) {
            return root;
        }
        if (val < root.val) {
            return searchBTS(root.left, val);
        } else {
            return searchBTS(root.right, val);
        }
    }
}
