package ShoulderU.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class PrintTreeByLevel {

    public void printTreeByLevel(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode rootNode = queue.poll();
            System.out.print(rootNode.data + " ");
            if (rootNode.leftChild != null) {
                queue.add(rootNode.leftChild);
            }
            if (rootNode.rightChild != null) {
                queue.add(rootNode.rightChild);
            }
        }
    }
}
