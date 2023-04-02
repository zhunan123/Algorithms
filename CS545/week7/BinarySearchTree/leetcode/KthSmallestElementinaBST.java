package CS545.week7.BinarySearchTree.leetcode;

import java.util.Stack;

public class KthSmallestElementinaBST {

    /**
     * Given the root of a binary search tree, and an integer k,
     * return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: root = [3,1,4,null,2], k = 1
     * Output: 1
     * */

    /**
     * need to use stack, in order traversal.  left most smallest, root 2nd most smallest, then right
     * and set  count < k, return the stack top smallest element.
     * */

    public int kthSmallest(TreeNode root, int k) {
        TreeNode current = root;
        int count = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (count < k) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                current = stack.pop();
                if (count + 1 == k) {
                    return current.val;
                }
                current =  current.right;
                count++;
            }
        }

        return current.val;
    }
}
