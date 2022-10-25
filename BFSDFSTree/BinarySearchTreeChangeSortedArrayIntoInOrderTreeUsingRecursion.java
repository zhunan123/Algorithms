package BFSDFSTree;

public class BinarySearchTreeChangeSortedArrayIntoInOrderTreeUsingRecursion {
    /**
     * 二叉搜索树，二叉排序树）它或者是一棵空树，或者是具有下列性质的二叉树：
     * 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值； 若它的右子树不空
     * ，则右子树上所有结点的值均大于它的根结点的值； 它的左、右子树也分别为二叉排序树。
     * 给一个排序数组（从小到大），将其转换为一棵高度最小的二叉搜索树。
     * 输入：[1,2,3,4,5,6,7]
     * 输出： {4,2,6,1,3,5,7}
     * 解释：
     * 拥有最小高度的二叉搜索树
     *
     *          4
     *        /   \
     *       2     6
     *      / \    / \
     *     1   3  5   7
     * */

    public TreeNode sortedArrayToBST(int[] nums) {
        // write your code here
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (left + right + 1) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);

        return root;
    }
}