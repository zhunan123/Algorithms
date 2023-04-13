package CS545.week8.GeneralTree;

public class GeneralTreeArray3 {
    private class TreeNode {
        int data;
        TreeNode leftChild;
        TreeNode rightChild;
        TreeNode parent;

        TreeNode[] children;
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
}
