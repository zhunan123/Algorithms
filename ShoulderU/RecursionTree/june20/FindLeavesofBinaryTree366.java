package ShoulderU.RecursionTree.june20;

import ShoulderU.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesofBinaryTree366 {
    public List<List<Integer>> findLeaves(TreeNode root) {
        // traverse the tree, while tree size not empty, so find all leaves add to list, delete them and go traversal again until the tree is empty
        // not touch the actual leaf, only toucht the parent node of leaf so can delete leaf easily
        // handle edge condition where only one last TreeNode left, just add it list and and add to ans list and return ans
        List<List<Integer>> ans = new ArrayList<>();
        while (root != null) {
            List<Integer> list = new ArrayList<>();
            // handle edge condition where only one last TreeNode left, just add it list and and add to ans list and return ans
            if (root.left == null && root.right == null) {
                list.add(root.val);
                ans.add(list);
                break;
            }
            inorder(root, list);
            ans.add(list);
        }
        return ans;
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if (root != null) {

            if (root.left != null) {
                if (root.left.left == null && root.left.right == null) { // find the leaf and add the leaf val to list
                    list.add(root.left.val); // add leaf
                    root.left = null; // delete leaf
                } else {
                    inorder(root.left, list);
                }
            }

            if (root.right != null) {
                if (root.right.left == null && root.right.right == null) {
                    list.add(root.right.val); // add leaf
                    root.right = null; // delete leaf
                } else {
                    inorder(root.right, list);
                }
            }
        }
    }
}
