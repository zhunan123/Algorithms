package ShoulderU.Tree;

public class SumOfLeftLeaves {

    /**
     * Given the root of a binary tree, return the sum of all left leaves.
     *
     * A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.
     * */


    /**
     * can have a heloper method compute the sum and pass in the boolean flag isLeft, and pass isLeft flag to true when doing computeLeftSum,
     * false when computeRightSum and only add leaf sum if leaf isLeft is true
     * */

    class Solution {
        int sum = 0; // for global variables
        public int sumOfLeftLeaves(TreeNode root) {
            sum = computeLeftSum(root, false);
            return sum;
        }

        public int computeLeftSum(TreeNode root, boolean isLeft) {
            if (root == null) {
                return 0;
            }

            if (root.left == null && root.right == null && isLeft == true) {
                return root.val;
            }

            sum = computeLeftSum(root.left, true) + computeLeftSum(root.right, false);

            return sum;
        }
    }
}
