package ShoulderU.RecursionTree.june21;

import ShoulderU.Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DeepestLeavesSum1302 {
    public int deepestLeavesSum(TreeNode root) {
        // create queue
        Queue<TreeNode> queue = new LinkedList<>();
        // create ans list where have each level node store in a list in ans list
        List<List<TreeNode>> ans = new ArrayList<>();
        queue.add(root);

        // start while loop poll the current root from queue and add left and right child to queue
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode polled = queue.poll();
                list.add(polled);

                if (polled.left != null) {
                    queue.add(polled.left);
                }
                if (polled.right != null) {
                    queue.add(polled.right);
                }
            }
            ans.add(list);
        }

        // find the last list in the ans list and add sum for the TreeNode
        List<TreeNode> last = ans.get(ans.size() - 1);
        // loop the last list and find sum
        int sum = 0;
        for (TreeNode node : last) {
            sum += node.val;
        }

        // return sum
        return sum;
    }
}
