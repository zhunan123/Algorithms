package CS545.week8.GeneralTree;

public class GeneralTreeArray3 {
    private static class TreeNode {
        int data;
        TreeNode[] children = new TreeNode[3];

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
            //only need virtually go through each children of root
            //dont need to worry about the children because recursion will take care of it
            sum += sum(root.children[i]);
        }

        return sum + root.data;
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < root.children.length; i++) {
            count += countNodes(root.children[i]);
        }

        return count + 1;
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

        node1.children[0] = node2;
        node1.children[1] = node3;
        node1.children[2] = node4;
        node2.children[0] = node5;
        node2.children[1] = node6;
        node3.children[1] = node7;
        node4.children[1] = node8;
        node4.children[2] = node9;

        GeneralTreeArray3 tree = new GeneralTreeArray3();

        int height = tree.getHeight(node1);
        System.out.println("tree height: " + height);

        int count = tree.countNodes(node1);
        System.out.println("Count nodes: " + count);

        int count2 = tree.countLeaf(node1);
        System.out.println("count leaf: " + count2);
    }
}
