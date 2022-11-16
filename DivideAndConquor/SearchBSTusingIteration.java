package DivideAndConquor;

public class SearchBSTusingIteration {
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
        while (root != null && root.val != val) {
            if (val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return root;
    }
}
