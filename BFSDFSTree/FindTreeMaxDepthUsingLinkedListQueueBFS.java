package BFSDFSTree;

public class FindTreeMaxDepthUsingLinkedListQueueBFS {


    public int maxDepth(TreeNode root) {
        // write your code here
        if (root == null){
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int count = 0;

        while (!q.isEmpty()){
            int size = q.size();
            while (size > 0){
                TreeNode cur = q.poll();
                if (cur.left != null){
                    q.offer(cur.left);
                }
                if (cur.right != null){
                    q.offer(cur.right);
                }
                size--;
            }
            count++;
        }
        return count;
    }
}