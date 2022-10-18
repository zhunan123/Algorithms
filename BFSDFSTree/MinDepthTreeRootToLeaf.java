package BFSDFSTree;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepthTreeRootToLeaf {

    /**
     * 输入:  {1,2,3,#,#,4,5}
     * 输出: 2
     * 解释:
     *       1
     *      / \
     *     2   3
     *        / \
     *       4   5
     * 它将被序列化为 {1,2,3,#,#,4,5}
     * */
    public class qNode {
        TreeNode node;
        int depth;

        public qNode (TreeNode node, int depth){
            this.node = node;
            this.depth = depth;
        }
    }
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }

        Queue<qNode> q = new LinkedList<qNode>();
        q.offer(new qNode(root, 1));
        while (!q.isEmpty()){
            qNode curQNode = q.poll();
            TreeNode curNode  = curQNode.node;
            int depth = curQNode.depth;

            if(curNode.left == null && curNode.right == null) {
                return depth;
            }
            if(curNode.left != null){
                q.offer(new qNode(curNode.left, depth + 1));
            }
            if(curNode.right != null){
                q.offer(new qNode(curNode.right, depth + 1));
            }
        }
        return 0;
    }
}
