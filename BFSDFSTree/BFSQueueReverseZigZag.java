package BFSDFSTree;

import java.util.*;

public class BFSQueueReverseZigZag {

    /**
     * tree = {1,2,3,4,5,6,7}
     *result ===> [[1],[3,2],[4,5,6,7]]
     *
     * */

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();

        if(root == null) {
            return lists;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean isLeftToRight = true;

        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<Integer>();
            int size = queue.size();

            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                list.add(node.val);

                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            if(!isLeftToRight) {
                Collections.reverse(list);
            }
            lists.add(list);
            isLeftToRight = !isLeftToRight;
        }
        return lists;
    }
}
