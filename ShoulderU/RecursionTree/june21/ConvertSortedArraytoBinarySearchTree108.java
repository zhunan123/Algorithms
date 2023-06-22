package ShoulderU.RecursionTree.june21;

import ShoulderU.Tree.TreeNode;

public class ConvertSortedArraytoBinarySearchTree108 {
    int[] arr;
    public TreeNode sortedArrayToBST(int[] nums) {
        arr = nums;
        return buildTree(0, arr.length - 1); // this is the range for low and high
    }

    public TreeNode buildTree(int low, int high) {
        // If left > right, then there is no elements available for that subtree.
        // base case
        if (low > high) {
            return null;
        }

        // recursive case
        // pick middle value as the root
        int mid = low + (high - low) / 2;
        // create BST with this mid as root
        TreeNode root = new TreeNode(arr[mid]);
        // assign root left value and root right value
        root.left = buildTree(low, mid - 1);
        root.right = buildTree(mid + 1, high);

        //return root
        return root;
    }
}
