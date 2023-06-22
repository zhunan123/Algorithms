package ShoulderU.RecursionTree.june22;

import ShoulderU.Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CountNodesEqualtoAverageofSubtree2265 {
    public class Result {
        public int sum;
        public int count;
    }
    public int averageOfSubtree(TreeNode root) {
        // traverse all the nodes we can do level by level, for every nodes we can do a inorder traversal, to find the average and compare to root val if equal add to count
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int ansCount = 0;
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            // do inorder traveral of all nodes and find average
            Result result = new Result(); // create a Result object to store sum and count
            inorder(current, result);
            int average = Math.round(result.sum / result.count);
            if (average == current.val) {
                ansCount++;
            }

            // add child
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return ansCount;
    }

    public void inorder(TreeNode root, Result result) {
        if (root != null) {
            inorder(root.left, result);
            result.sum += root.val;
            result.count++;
            inorder(root.right, result);
        }
    }
}
