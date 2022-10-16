package BFSDFSTree;

import java.util.LinkedList;
import java.util.Queue;

public class LeafSumUsingBFSIteration {

    /**
     * 输入：{1,2,3,4}
     * 输出：7
     * 解释：
     *     1
     *    / \
     *   2   3
     *  /
     * 4
     * 3+4=7
     * */
   public int leafSum(TreeNode root) {
           if (root == null) {
               return 0;
           }

           Queue<TreeNode> q = new LinkedList<>();
           q.offer(root);
           Queue<TreeNode> leafList = new LinkedList<>();
           while (!q.isEmpty()){
               int size = q.size();
               for (int i = 0; i < size; i++) {
                   TreeNode cur = q.poll();
                   if (cur.left == null && cur.right == null){
                       leafList.offer(cur);
                   }
                   if (cur.left != null) {
                       q.offer(cur.left);
                   }
                   if (cur.right != null) {
                       q.offer(cur.right);
                   }
               }
           }

           int sum = 0;
           while (!leafList.isEmpty()) {
               sum += leafList.poll().val;
           }

           return sum;
       }
}