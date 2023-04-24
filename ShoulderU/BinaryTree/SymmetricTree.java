package ShoulderU.BinaryTree;

import ShoulderU.Tree.TreeNode;

public class SymmetricTree {

    /**
     * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
     *
     *
     *
     * Example 1:
     *
     *
     * Input: root = [1,2,2,3,4,4,3]
     * Output: true
     * */

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return checkSym(root.left, root.right);
    }

    public boolean checkSym(TreeNode rootleft, TreeNode rootright) {
        if (rootleft == null && rootright == null) {
            return true;
        }

        //if any of rootleft or rootright is null, then its not symmetrical, then return false
        if (rootleft == null || rootright == null) {
            return false;
        }

        if (rootleft.val != rootright.val) {
            return false;
        }

        return checkSym(rootleft.left, rootright.right) && checkSym(rootright.left, rootleft.right);
    }
}
