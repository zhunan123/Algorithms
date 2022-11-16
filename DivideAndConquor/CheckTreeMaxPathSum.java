package DivideAndConquor;

public class CheckTreeMaxPathSum {
    /**
     * tree = {1,2,3}
     * 输出：
     *
     * 6
     * 解释：
     *
     * 如下图，最长路径为2-1-3
     *       1
     *      / \
     *     2   3
     * */
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }

        getMaxOnePathSum(root);
        return maxSum;
    }

    public int getMaxOnePathSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftMaxPath = getMaxOnePathSum(node.left);
        int rightMaxPath = getMaxOnePathSum(node.right);

        maxSum = Math.max(maxSum, leftMaxPath + rightMaxPath + node.val);
        int maxOnePathSum = node.val + Math.max(leftMaxPath, rightMaxPath);

        return maxOnePathSum > 0 ? maxOnePathSum : 0;
    }
}
