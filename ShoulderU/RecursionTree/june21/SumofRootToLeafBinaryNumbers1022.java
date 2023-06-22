package ShoulderU.RecursionTree.june21;

import ShoulderU.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SumofRootToLeafBinaryNumbers1022 {
    public int sumRootToLeaf(TreeNode root) {
        List<String> list = new ArrayList<>();
        return helper(root, list, new StringBuilder());
    }

    public int helper(TreeNode root, List<String> list, StringBuilder sb) {
        if (root == null) {
            return 0;
        }
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            list.add(sb.toString());
            return Integer.parseInt(sb.toString(), 2);
        }

        int sum = helper(root.left, list, new StringBuilder(sb)) + helper(root.right, list, new StringBuilder(sb));

        return sum;
    }
}
