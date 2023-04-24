package ShoulderU.BinaryTree;

import ShoulderU.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindAllTheLonelyNodes {

    /**
     * In a binary tree, a lonely node is a node that is the only child of its parent node. The root of the tree is not lonely because it does not have a parent node.
     *
     * Given the root of a binary tree, return an array containing the values of all lonely nodes in the tree. Return the list in any order.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: root = [1,2,3,null,4]
     * Output: [4]
     * Explanation: Light blue node is the only lonely node.
     * Node 1 is the root and is not lonely.
     * Nodes 2 and 3 have the same parent and are not lonely.
     * */

    class Solution {
        public List<Integer> getLonelyNodes(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            findAndAddLonelyNodes(root, list);

            return list;
        }

        public void findAndAddLonelyNodes(TreeNode root, List list) {
            if (root == null) {
                return;
            }

            if (root.left == null && root.right == null) {
                return;
            }

            if (root.left == null && root.right != null) {
                list.add(root.right.val);
            }

            if (root.right == null && root.left != null) {
                list.add(root.left.val);
            }

            findAndAddLonelyNodes(root.left, list);
            findAndAddLonelyNodes(root.right, list);
        }
    }
}
