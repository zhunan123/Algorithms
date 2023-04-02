package CS545.week7.BinarySearchTree.leetcode;

public class ClosestBinarySearchTreeValue {

    public TreeNode root;

    public void insert(int elem) {
        if (root == null) {
            root = new TreeNode(elem);
            return;
        }

        TreeNode prev = null;
        TreeNode current = root;
        while (current != null) {
            if (elem < current.val) {
                prev = current;
                current = current.left;
            } else {
                prev = current;
                current = current.right;
            }
        }

        if (elem > prev.val) {
            prev.right = new TreeNode(elem);
        } else {
            prev.left = new TreeNode(elem);
        }
    }

    public void printPreOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            printPreOrder(root.left);
            printPreOrder(root.right);
        }
    }

    public TreeNode findClosest(TreeNode root, double target) {
        while (root != null) {
            if (target < root.val) { //target 比root小
                if (target < root.val && target > root.left.val) { //在root 和 root.left 这个区间
                    if ((root.val - target) > (target - root.left.val)) {
                        return root.left;
                    } else {
                        break;
                    }
                } else {//不在这个区间
                    root = root.left;
                }
            } else {//target 比root大
                if (target > root.val && target < root.right.val) {
                    //在root 和root.right 这个区间
                    if ((target - root.val) > (root.right.val - target)) {
                        return root.right;
                    } else {
                        break;
                    }
                } else { //不在这个区间
                    root = root.right;
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        ClosestBinarySearchTreeValue tree = new ClosestBinarySearchTreeValue();
        tree.insert(4);
        tree.insert(2);
        tree.insert(5);
        tree.insert(1);
        tree.insert(3);

        tree.printPreOrder(tree.root);
        System.out.println();
        double target = 2.114286;
        TreeNode node = tree.findClosest(tree.root, target);
        System.out.println(node.val);
    }
}
