package ShoulderU.BinaryTree;


import CS545.week7.BinarySearchTree.exercise.BST4;

public class checkTreeIdentical {

    private class BSTNode {
        public BSTNode[] children;
        int data;
        BSTNode left;
        BSTNode right;

        BSTNode(int newdata) {
            data = newdata;
        }
    }

    public static boolean checkIfIdentical(BSTNode root1, BSTNode root2) {
        // FILL IN CODE
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.data != root2.data) {
            return false;
        }

        return checkIfIdentical(root1.left, root2.left) && checkIfIdentical(root1.right, root2.right);
    }
}
