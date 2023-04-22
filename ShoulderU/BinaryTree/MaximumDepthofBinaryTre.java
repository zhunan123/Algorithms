package ShoulderU.BinaryTree;

import ShoulderU.Tree.TreeNode;

public class MaximumDepthofBinaryTre {

    /**
     * Given the root of a binary tree, return its maximum depth.
     *
     * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: root = [3,9,20,null,null,15,7]
     * Output: 3
     * */

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int height = Math.max(maxDepth(root.left), maxDepth(root.right));

        return height + 1;
    }
}
