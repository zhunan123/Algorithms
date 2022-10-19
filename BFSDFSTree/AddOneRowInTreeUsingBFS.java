package BFSDFSTree;

public class AddOneRowInTreeUsingBFS {

    /**
     * 输入:
     * 一棵如下所示的二叉树:
     *        4
     *      /   \
     *     2     6
     *    / \   /
     *   3   1 5
     * v = 1
     * d = 2
     * 输出:
     *        4
     *       / \
     *      1   1
     *     /     \
     *    2       6
     *   / \     /
     *  3   1   5
     * */

    public TreeNode addOneRow(TreeNode root, int v, int d) {

        if (d == 1){
            TreeNode newRoot = new TreeNode(v);
            newRoot .left = root;
            return newRoot;
        }

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);

        int depth = 1;
        while(depth < d - 1){
            Queue<TreeNode> temp = new LinkedList<>();
            while(!q.isEmpty()){
                TreeNode curNode = q.poll();
                if(curNode.left != null) {
                    temp.offer(curNode.left);
                }
                if(curNode.right != null) {
                    temp.offer(curNode.right);
                }
            }
            q = temp;
            depth++;
        }


        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            TreeNode temp = node.left;
            node.left = new TreeNode(v);
            node.left.left = temp;
            temp = node.right;
            node.right = new TreeNode(v);
            node.right.right = temp;
        }

        return root;
    }
}
