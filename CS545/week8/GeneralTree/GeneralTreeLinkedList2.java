package CS545.week8.GeneralTree;

import CS545.week6.queue.ImplementQueueUsingArray;

public class GeneralTreeLinkedList2 {

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
        ImplementQueueUsingArray q = new ImplementQueueUsingArray();
        q.enqueue(root);

        while(!q.isEmpty()) {
            TreeNode node = (TreeNode) q.dequeue();
            System.out.print(node.data + " ");
            TreeNode current = node.leftChild;
            while (current != null) {
                q.enqueue(current);
                current = current.rightSibling;
            }
        }
    }

    public void printByLevel2(TreeNode root) {
        ImplementQueueUsingArray q = new ImplementQueueUsingArray();
        q.enqueue(root);

        while(!q.isEmpty()) {
            TreeNode node = (TreeNode) q.dequeue();
            for(TreeNode current = node.leftChild; current != null; current = current.rightSibling) {
                q.enqueue(current);
            }
        }
    }

    private void printPreorder(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        TreeNode current = root.leftChild;

        while (current != null) {
            printPreorder(current);
            current = current.rightSibling;
        }

        System.out.print(")"); //why adding this at this level? I think no left child means no child so we dont with this node
    }

    private int height(TreeNode root) {
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

    boolean isLeaf(TreeNode node) {
        TreeNode current = node.leftChild;
        if (current != null) {
            return false;
        }
        return true;
    }

    private int getLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (isLeaf(root)) {
            return 1;
        }

        int count = 0;

        TreeNode current = root.leftChild;
        while (current != null) {
            count += getLeaf(current);
            current = current.rightSibling;
        }

        return count;
    }

    private int getNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        TreeNode current  = root.leftChild;
        //don't need to worry about the current's child recursion, only worry about current's rightSibling
        while (current != null) {
            count += getNodes(current);
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

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.leftChild = node2;
        node2.rightSibling = node3;
        node2.leftChild = node4;
        node4.rightSibling = node5;
        node3.leftChild = node6;

        GeneralTreeLinkedList2 tree = new GeneralTreeLinkedList2();
        int count = tree.getNodes(node1);
        System.out.println("Count: " + count);

        int sum = tree.sum(node1);
        System.out.println("Sum: " + sum);

        int count2 = tree.getLeaf(node1);
        System.out.println("count leaf: " + count2);

        int height = tree.height(node1);
        System.out.println("tree height: " + height);

        tree.printPreorder(node1);

        tree.printByLevel(node1);


    }

}
