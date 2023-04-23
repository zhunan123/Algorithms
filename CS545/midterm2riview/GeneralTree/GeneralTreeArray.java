package CS545.midterm2riview.GeneralTree;

import CS545.week8.GeneralTree.GeneralTreeArray3;

public class GeneralTreeArray {

    private static class TreeNode {
        int data;
        TreeNode[] children = new GeneralTreeArray.TreeNode[3];

        TreeNode(int newdata) {
            data = newdata;
        }
    }

    private TreeNode root;

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxH = 0;
        for (int i = 0; i < root.children.length; i++) {
            int currH = getHeight(root.children[i]);
            if (currH > maxH) {
                maxH = currH;
            }
        }
        return maxH + 1;
    }

    public boolean isLeaf(TreeNode root) {
        for (int i = 0; i < root.children.length; i++) {
            if (root.children[i] != null) {
                return false;
            }
        }
        return true;
    }

    public int countLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (isLeaf(root)) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < root.children.length; i++) {
            count += countLeaf(root.children[i]);
        }
        return count;
    }

    public int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        for (int i = 0; i < root.children.length; i++) {
            sum += sum(root.children[i]);
        }
        return sum + root.data;
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i< root.children.length; i++) {
            count += countNodes(root.children[i]);
        }

        return count + 1;
    }

    public void printPreOrder(TreeNode root) { //print when done with the child
        //---->125///6////3/7////4/8///9/// if child is null print /
//        if (root != null) {
//            System.out.print(root.data);
//            for (int i = 0; i < root.children.length; i++) {
//                printPreOrder(root.children[i]);
//            }
//        } else {
//            System.out.print("/");
//        }

        //this below is when done print ) which is serialization
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        for (int i = 0; i < root.children.length; i++) {
            printPreOrder(root.children[i]);
        }
        // this below is when doine with the child need to print )
        System.out.print(")");

    }
}
