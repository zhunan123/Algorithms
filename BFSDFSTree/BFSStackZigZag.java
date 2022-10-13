package BFSDFSTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BFSStackZigZag {

    /**
     * tree = {1,2,3,4,5,6,7}
     *result ===> [[1],[3,2],[4,5,6,7]]
     *
     * */

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> lists= new ArrayList<List<Integer>>();

        if(root == null) {
            return lists;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> nextStack = new Stack<TreeNode>();
        boolean leftToRight = true;

        stack.push(root);
        while(!stack.isEmpty()){
            List<Integer> list = new ArrayList<Integer>();
            while(!stack.isEmpty()){
                TreeNode currentNode = stack.pop();
                if(currentNode == null) {
                    continue;
                }
                list.add(currentNode.val);
                if(leftToRight){
                    stack.push(currentNode.left);
                    stack.push(currentNode.right);
                }else {
                    stack.push(currentNode.right);
                    stack.push(currentNode.left);
                }
            }

            leftToRight = !leftToRight;
            if(list.size() > 0){
                lists.add(list);
            }

            Stack<TreeNode> tempStack = stack;
            stack = nextStack;
            nextStack = tempStack;

        }
        return lists;
    }
}
