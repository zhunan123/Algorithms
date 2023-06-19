package ShoulderU.RecursionTree.june19;

import ShoulderU.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MinimumDistanceBetweenBSTNodes783 {
    List<Integer> list = new ArrayList<>();
    public int minDiffInBST(TreeNode root) {
        // store all the nodes value into a arraylist use inorder traversal, then find the smallest pair diff within the list
        inOrderTraversal(root);
        int smallestD = Integer.MAX_VALUE;
        // loop through the node value list and find the smallest distance difference
        for (int i = 0; i < list.size(); i++) {
            int current = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                int diff = list.get(j) - list.get(i);
                if (diff < smallestD) {
                    smallestD = diff;
                }
            }
        }
        return smallestD;
    }

    public void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrderTraversal(root.left);
        list.add(root.val);
        inOrderTraversal(root.right);
    }
}
