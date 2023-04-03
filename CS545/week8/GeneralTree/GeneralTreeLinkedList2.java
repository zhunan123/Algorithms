package CS545.week8.GeneralTree;

import CS545.week6.queue.ImplementQueueUsingArray;

public class GeneralTreeLinkedList2 {

    private class TreeNode {
        int data;
        TreeNode leftChild;
        TreeNode rightChild;
        TreeNode parent;

        TreeNode[] children;

    }

    public void printByLevel(TreeNode root) {
        ImplementQueueUsingArray q = new ImplementQueueUsingArray();
        q.enqueue(root);

        while(!q.isEmpty()) {
            TreeNode node = (TreeNode) q.dequeue();
            System.out.print(node.data + " ");
            TreeNode current = root.leftChild;
            while (current != null) {
                q.enqueue(current);
                current = current.rightChild;
            }
        }
    }

    public void printByLevel2(TreeNode root) {
        ImplementQueueUsingArray q = new ImplementQueueUsingArray();
        q.enqueue(root);

        while(!q.isEmpty()) {
            TreeNode node = (TreeNode) q.dequeue();
            for(TreeNode current = node.leftChild; current != null; current = current.rightChild) {
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
            printPreorder(root);
            current = current.rightChild;
        }

        System.out.print(")");
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
            current = current.rightChild;
        }

        return maxH + 1;
    }

    boolean isLeaf(TreeNode node) {
        for (int i = 0; i < node.children.length; i++) {
            if (node.children[i] == null) {
                return false;
            }
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
//        TreeNode current = root.leftChild;
//        while (current != null) {
//            count += getLeaf(current);
//            current = current.rightChild;
//        }
        while (root != null) {
            count += getLeaf(root.leftChild);
            root = root.rightChild;
        }

        return count;
    }

    private int getNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        while (root != null) {
            count += getNodes(root.leftChild);
            root = root.rightChild;
        }

        return count + 1;
    }

    private int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        while (root != null) {
            sum += sum(root.leftChild);
            root = root.rightChild;
        }

        return sum + root.data;
    }

}
