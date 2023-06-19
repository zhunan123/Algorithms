package ShoulderU.RecursionTree.june18;

import ShoulderU.Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView199 {
    /**
     create queue using linkedlist, add root to queue, while queue is not empty, record queue size and for loop from 0 to size ,
     poll the queue current element, check condition if i is the last element,
     if is add to ans, then add polled element left and right child into queue. finally return ans
     */
    public List<Integer> rightSideView(TreeNode root) {
        // create ans list array
        List<Integer> ans = new ArrayList<>();
        // create queue using linkedlist
        Queue<TreeNode> queue = new LinkedList<>();
        // add root to queue
        queue.add(root);

        // start loop
        while (!queue.isEmpty()) {
            // find the size for the current level of tree in the queue
            int size = queue.size();
            // poll queue size element(poll previous level tree elements) and add new level tree elements into queue
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp != null) { // check only if temp is not null
                    // check if is the last element and add to res array
                    if (i == size - 1) {
                        ans.add(temp.val);
                    }
                    // add the left child and right child into root and form the new level into queue
                    if (temp.left != null) {
                        queue.add(temp.left);
                    }
                    if (temp.right != null) {
                        queue.add(temp.right);
                    }
                }
            }
        }
        return ans;
    }
}
