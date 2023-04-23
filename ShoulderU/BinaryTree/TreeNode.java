package ShoulderU.BinaryTree;


public class TreeNode {
    int data;
    TreeNode leftChild;
    TreeNode rightSibling;
    TreeNode parent;
    TreeNode rightChild;

    TreeNode[] children;

    TreeNode(int newdata) {
        data = newdata;
    }
}
