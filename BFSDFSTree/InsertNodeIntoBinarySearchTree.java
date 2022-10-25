package BFSDFSTree;

public class InsertNodeIntoBinarySearchTree {
    /**
     * 输入：
     * tree = {2,1,4,#,#,3}
     * node = 6
     * 输出：
     *
     * {2,1,4,#,#,3,6}
     * 解释：
     *
     * 如下:
     *    2                              2
     *  /   \                          /   \
     * 1     4          -->           1     4
     *     /                              /  \
     *    3                              3    6
     *
     * */

    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here

        if (root == null){
            return node;
        }

        TreeNode curPos = root;
        while (curPos != null) {
            if (node.val < curPos.val) {
                if (curPos.left == null){
                    curPos.left = node;
                    break;
                } else {
                    curPos = curPos.left;
                }
            } else {
                if (curPos.right == null) {
                    curPos.right = node;
                    break;
                } else {
                    curPos = curPos.right;
                }

            }
        }
        return root;
    }
}