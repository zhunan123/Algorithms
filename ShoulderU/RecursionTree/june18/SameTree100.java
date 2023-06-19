package ShoulderU.RecursionTree.june18;

import ShoulderU.Tree.TreeNode;

public class SameTree100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return helper(p, q);
    }

    public boolean helper(TreeNode root1, TreeNode root2) {
        // base case 1
        if (root1 == null && root2 == null) {
            return true;
        }
        // base case 2
        if (root1 == null || root2 == null) {
            return false;
        }
        // base case 3
        if (root1.val != root2.val) {
            return false;
        }

        // recursive case
        return helper(root1.left, root2.left) && helper(root1.right, root2.right);
    }
}
