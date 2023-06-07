package ShoulderU.Stack.june5;

import ShoulderU.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode popped = stack.pop();
                result.add(popped.val);

                if (popped.right != null) {
                    stack.push(popped.right);
                }
                if (popped.left != null) {
                    stack.push(popped.left);
                }
            }
        }
        return result;
    }
}
