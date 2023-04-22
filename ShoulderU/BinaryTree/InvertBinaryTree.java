package ShoulderU.BinaryTree;

import ShoulderU.Tree.TreeNode;

public class InvertBinaryTree {

    /**
     * Given the root of a binary tree, invert the tree, and return its root.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: root = [4,2,7,1,3,6,9]
     * Output: [4,7,2,9,6,3,1]
     * */

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp  =root.left;

        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
}
