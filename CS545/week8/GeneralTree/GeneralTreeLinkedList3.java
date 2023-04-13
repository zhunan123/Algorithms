package CS545.week8.GeneralTree;

import CS545.week6.queue.ImplementQueueUsingArray;

public class GeneralTreeLinkedList3 {

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
        //idea: first created queue, push root
        //while queue is not empty, deleted the queue head, then add head's children if any

        ImplementQueueUsingArray queue = new ImplementQueueUsingArray();
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            TreeNode current = (TreeNode) queue.dequeue();
            System.out.print(current.data + " ");

            TreeNode leftChild = current.leftChild;
            while (leftChild != null) {
                queue.enqueue(leftChild);
                leftChild = leftChild.rightSibling;
            }
        }
    }

    public void printPreOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        TreeNode node = root.leftChild;
        while (node != null) {
            printPreOrder(node);
            node = node.rightSibling;
        }
        //print ")" when done with the node
        System.out.print(")");

    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxH = 0;
        TreeNode node = root.leftChild;
        while(node != null) {
            int currH = height(node);
            if (currH > maxH) {
                maxH = currH;
            }
            node = node.rightSibling;
        }
        return maxH + 1;
    }

    public boolean isLeaf(TreeNode root) {
        TreeNode node = root.leftChild;
        if (node != null) {
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
        TreeNode node = root.leftChild;
        while (node != null) {
            count += countLeaf(node);
            node = node.rightSibling;
        }

        return count;
    }

    private int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int count = 0;

        TreeNode node = root.leftChild;
        while (node != null) {
            count += countNodes(node);
            node = node.rightSibling;
        }

        return count + 1;
    }

    private int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        TreeNode node = root.leftChild;
        while (node != null) {
            sum += sum(node);
            node = node.rightSibling;
        }

        return sum + root.data;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);

        node1.leftChild = node2;
        node2.rightSibling = node3;
        node3.rightSibling = node4;
        node2.leftChild = node5;
        node5.rightSibling = node6;
        node4.leftChild = node7;
        node7.rightSibling = node8;
        node8.rightSibling = node9;

        GeneralTreeLinkedList3 tree = new GeneralTreeLinkedList3();
        tree.printByLevel(node1);
        System.out.println("ln");
        tree.printPreOrder(node1);
    }
}
