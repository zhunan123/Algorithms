package ShoulderU.RecursionTree.june21;

import ShoulderU.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SumofRootToLeafBinaryNumbers1022 {
    public int sumRootToLeaf(TreeNode root) {
        return helper(root, new StringBuilder());
    }

    public int helper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return 0;
        }
        sb.append(root.val);

        if (root.left == null && root.right == null) {
            return Integer.parseInt(sb.toString(), 2);
        }

        int sum = helper(root.left, new StringBuilder(sb)) + helper(root.right, new StringBuilder(sb));

        return sum;
    }
}
