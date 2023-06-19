package ShoulderU.RecursionTree;

import ShoulderU.Tree.TreeNode;

public class ValidateBinarySearchTree98 {
    public boolean isValidBST(TreeNode root) {
        // need to pass additional min value allowed for the node and the maximum value allowed for the nodes
        // in that case will be sufficient otherwise we are only checking for the current node's children's value is not sufficient for the entire BST tree
        // need to use Integer wrapper class which encapculate int and has null value, int is a primitive data type
        return helper(root, null, null);
    }

    public boolean helper(TreeNode root, Integer low, Integer high) {
        // base case 1, empty root is valid as well
        if (root == null) {
            return true;
        }
        // root.val has to be in the range  low_val_allowed<root.val<high_val_allowed
        // base case 2, since low is Integer class so it can be null
        if ((low != null && root.val <= low) || (high != null && root.val >= high)) {
            return false;
        }

        // recursive case
        return helper(root.left, low, root.val) && helper(root.right, root.val, high);
    }
}
