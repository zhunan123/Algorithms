package ShoulderU.RecursionTree.june19;

import ShoulderU.Tree.TreeNode;

public class PathSum112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {

        // base case is when root == null means no path directly return false
        //then update sum first, sum += root.val, then check if the node is leaf and has sum = targetSum if yes return true
        // recursive case, return helper(root.left) or helper(root.right), if either one works is ok
        int sum = 0;
        return helper(root, sum, targetSum);
    }

    public boolean helper(TreeNode root, int sum, int targetSum) {
        //base case
        if (root == null) {
            return false;
        }

        // need first update sum, then check the pathsum
        sum += root.val;
        if (root.left == null && root.right == null) {
            if (sum == targetSum) {
                return true;
            }
        }

        return helper(root.left, sum, targetSum) || helper(root.right, sum, targetSum);
    }
}
