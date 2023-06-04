package ShoulderU.Stack.june3;

import ShoulderU.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeIterator173 {
    /**
     * put all BST node into a arraylist using in order traversal,
     * inside the constructor just need to compute the inorder traversal to put all nodes into the array.
     * then just implement next() and hasNext() function
     * */
    List<Integer> list = new ArrayList<Integer>(); // need list to add nodes in order traversal into this list
    int index = -1; // need this index start from -1 so when we increment 1 we can start from 0, need this index for next and hasNext
    public BinarySearchTreeIterator173(TreeNode root) {
        // compute in order traversal and put all the nodes into list array
        computeInorderTraversal(root);
    }

    public int next() {
        index++; // need to increment index to advance to next index
        int nextInt = list.get(index);
        return nextInt;
    }

    public boolean hasNext() {
        if (index + 1 < list.size()) {
            return true;
        }
        return false;
    }

    public void computeInorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        computeInorderTraversal(root.left);
        // then add to list array to flatten
        list.add(root.val);
        computeInorderTraversal(root.right);
    }
}
