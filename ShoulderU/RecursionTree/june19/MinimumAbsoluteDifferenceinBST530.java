package ShoulderU.RecursionTree.june19;

import ShoulderU.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MinimumAbsoluteDifferenceinBST530 {
    List<Integer> list = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            int current = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                int diff = Math.abs(list.get(j) - list.get(i));
                if (diff < smallest) {
                    smallest = diff;
                }
            }
        }
        return smallest;
    }

    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            list.add(root.val);
            inorder(root.right);
        }
    }
}
