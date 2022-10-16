package BFSDFSTree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelSumUsingBFS {
    /**
     * 输入：{1,2,3,4,5,6,7,#,#,8,#,#,#,#,9},2
     * 输出：5
     * 解释：
     *      1
     *    /   \
     *   2     3
     *  / \   / \
     * 4   5 6   7
     *    /       \
     *   8         9
     * 2+3=5
     * */
    public int levelSum(TreeNode root, int level) {

        if (root == null || level < 1) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int sum = 0;
        int count = 1;
        queue.offer(root);
        while (!queue.isEmpty() && count < level) {
            count++;
            int size = queue.size();
            for (int i = 0;i < size; i++) {
                TreeNode cur = queue.poll();
                if(cur.left != null) {
                    queue.offer(cur.left);
                }
                if(cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }

        if (count == level){
            while (!queue.isEmpty()){
                int front = queue.poll().val;
                sum += front;
            }
        }
        return sum;
    }
}