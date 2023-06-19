package ShoulderU.RecursionTree.june19;

import ShoulderU.Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class findSmallestDistanceBetweenParentAndChildNode {
    public int minDiffInBST(TreeNode root) {
        // 只需要寻找每一层的每一个跟其left child和right child最小的diff就可以了，不用考虑不同层之间的距离
        // this method only compare the differences between a parent node and its immediate children, incorrect
        // use Queue
        Queue<TreeNode> q = new LinkedList<>();
        // define smallest distance
        int smallestD = Integer.MAX_VALUE;
        // add root into queue
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            // loop each level of BST
            for (int i = 0; i < size; i++) {
                TreeNode polled = q.poll();
                // calculate left child diff and right child diff and update smallestD and add it to q
                if (polled.left != null) {
                    int currentD = polled.val - polled.left.val;
                    if (currentD < smallestD) {
                        smallestD = currentD;
                    }
                    // add left child into q
                    q.add(polled.left);
                }

                if (polled.right != null) {
                    int currentD = polled.right.val - polled.val;
                    if (currentD < smallestD) {
                        smallestD = currentD;
                    }
                    // add left child into q
                    q.add(polled.right);
                }
            }
        }
        return smallestD;
    }
}
