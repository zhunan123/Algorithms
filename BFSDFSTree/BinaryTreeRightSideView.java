package BFSDFSTree;

public class BinaryTreeRightSideView {
    /**
     *给定一棵二叉树，想象自己站在它的右侧，
     * 按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
     * 样例
     * 输入: {1,2,3,#,5,#,4}
     * 输出: [1,3,4]
     * 说明:
     *    1
     *  /   \
     * 2     3
     *  \     \
     *   5     4
     *
     *
     * */

    public List<Integer> rightSideView(TreeNode root) {
        // write your code here

        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i=0;i<size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
                if(i == size - 1) {
                    res.add(node.val);
                }
            }
        }
        return res;
    }
}