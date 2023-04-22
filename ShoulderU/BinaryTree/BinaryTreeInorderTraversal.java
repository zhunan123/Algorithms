package ShoulderU.BinaryTree;

import ShoulderU.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    /**
     * Given the root of a binary tree, return the inorder traversal of its nodes' values.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: root = [1,null,2,3]
     * Output: [1,3,2]
     * */

    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();

            inorderTraversal2(root, list);
            return list;
        }

        public void inorderTraversal2(TreeNode root, List list) {
            if (root != null) {
                inorderTraversal2(root.left, list);
                list.add(root.val);
                inorderTraversal2(root.right, list);
            }
        }
    }
}
