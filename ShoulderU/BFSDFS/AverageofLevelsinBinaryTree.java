package ShoulderU.BFSDFS;

import ShoulderU.Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageofLevelsinBinaryTree {

    /**
     * Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.
     *
     *
     * Example 1:
     *
     *
     * Input: root = [3,9,20,null,null,15,7]
     * Output: [3.00000,14.50000,11.00000]
     * Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
     * Hence return [3, 14.5, 11].
     * */

    /**
     * key is to find queue size for each level before adding more children
     * and have a for loop to poll only queue size children to ensure not adding children children into average
     * */

    class Solution {
        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> result = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();

            queue.add(root);

            while (!queue.isEmpty()) {
                int size = queue.size();
                double sum = 0;
                for (int i = 0; i < size; i++) {
                    TreeNode temp = queue.poll();
                    sum += temp.val;
                    if (temp.left != null) {
                        queue.add(temp.left);
                    }
                    if (temp.right != null) {
                        queue.add(temp.right);
                    }
                }
                result.add((double) sum / size);
            }

            return result;
        }
    }
}
