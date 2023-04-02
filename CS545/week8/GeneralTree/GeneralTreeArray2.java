package CS545.week8.GeneralTree;

public class GeneralTreeArray2 {
    private class TreeNode {
        int data;
        TreeNode leftChild;
        TreeNode rightChild;
        TreeNode parent;

        TreeNode[] children;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxH = 0;
        for (int i = 0; i < root.children.length; i++) {
            int currH = height(root.children[i]);
            if (currH > maxH) {
                maxH = currH;
            }
        }
        return maxH + 1;
    }

    public int height2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxH = 0;
        for (int i =0; i < root.children.length; i++) {
            int currH = height2(root.children[i]);
            maxH = Math.max(maxH, currH);
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


    public int countleaf(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (isLeaf(root)) {
            return 1;
        }

        int count = 0;
        for (int i = 0 ; i < root.children.length; i++) {
            count += countleaf(root.children[i]);
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
        for (int i = 0; i < root.children.length; i++) {
            count += countNodes(root.children[i]);
        }
        return count + 1;
    }

}
