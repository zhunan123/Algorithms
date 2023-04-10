package CS545.week7.BinarySearchTree.leetcode;

public class DeleteNodeInBST {

    /**
     * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
     *
     * Basically, the deletion can be divided into two stages:
     *
     * Search for a node to remove.
     * If the node is found, delete the node.
     *
     *
     * Example 1:
     *
     *
     * Input: root = [5,3,6,2,4,null,7], key = 3
     * Output: [5,4,6,2,null,null,7]
     * Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
     * One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
     * Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.
     * */

    public int findAndRemoveSmallest(TreeNode root) {
        if (root.left.left == null) {
            int smallest = root.left.val;
            root.left = root.left.right;
            return smallest;
        } else {
            return findAndRemoveSmallest(root.left);
        }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                if (root.right.left == null) {
                    root.val = root.right.val;
                    root.right = root.right.right;
                    return root;
                } else {
                    root.val = findAndRemoveSmallest(root.right);
                    return root;
                }
            }

        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        } else {
            root.right = deleteNode(root.right, key);
            return root;
        }
    }
}
