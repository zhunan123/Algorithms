package CS545.midterm2riview.GeneralTree;

import CS545.week6.queue.ImplementQueueUsingArray;
import CS545.week8.GeneralTree.GeneralTreeLinkedList3;

import java.util.LinkedList;
import java.util.Queue;

public class GeneralLinedList {

    private static class TreeNode {
        int data;
        TreeNode leftChild;
        TreeNode rightSibling;
        TreeNode parent;

        TreeNode[] children;

        TreeNode(int newdata) {
            data = newdata;
        }
    }

    public void printByLevel(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.print(temp.data + " ");
            TreeNode current = temp.leftChild;
            while (current != null) {
                queue.add(current);
                current = current.rightSibling;
            }
        }

    }

    public void printPreOrder(TreeNode root) { //print ) when done with the node

        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        TreeNode leftChild = root.leftChild;
        while(leftChild != null) {
            printPreOrder(leftChild);
            leftChild = leftChild.rightSibling;
        }
        //when done with all the child of this node print ")"
        System.out.print(")");
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxH = 0;
        TreeNode current = root.leftChild;
        while (current != null) {
            int currH = height(current);
            if (currH > maxH) {
                maxH = currH;
            }
            current = current.rightSibling;
        }
        return maxH + 1;
    }

    public boolean isLeaf(TreeNode root) {
        if (root.leftChild != null) {
            return false;
        }
        return true;
    }

    private int countLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (isLeaf(root)) {
            return 1;
        }

        int count = 0;
        TreeNode current = root.leftChild;
        while (current != null) {
            count += countLeaf(current);
            current = current.rightSibling;
        }
        return count;
    }

    private int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int count = 0;
        TreeNode current = root.leftChild;
        while (current != null) {
            count += countNodes(current);
            current = current.rightSibling;
        }
        return count + 1;
    }

    private int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        TreeNode current = root.leftChild;
        while (current != null) {
            sum += sum(current);
            current = current.rightSibling;
        }

        return sum + root.data;
    }
}
