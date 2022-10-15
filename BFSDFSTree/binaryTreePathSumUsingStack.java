package BFSDFSTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class binaryTreePathSumUsingStack {

    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {

        /**
         *
         * 输入:
         * {1,2,4,2,3}
         * 5
         * 输出: [[1, 2, 2],[1, 4]]
         * 说明:
         * 这棵树如下图所示：
         * 	     1
         * 	    / \
         * 	   2   4
         * 	  / \
         * 	 2   3
         * 对于目标总和为5，很显然1 + 2 + 2 = 1 + 4 = 5*/

        List<List<Integer>> lists = new ArrayList<List<Integer>>();

        if(root == null) {
            return lists;
        }

        int sum = 0;
        TreeNode cur = root;
        TreeNode prev = null;
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                sum += cur.val;
                list.add(cur.val);
                cur = cur.left;
            }

            if (!stack.isEmpty()) {
                cur = stack.peek();
                boolean canPop = cur.right == null || cur.right == prev;
                prev = cur;
                if (canPop) {
                    if(sum == target && cur.left == null && cur.right == null){
                        lists.add(new ArrayList<>(list));
                    }
                    sum -= cur.val;
                    stack.pop();
                    list.remove(list.size() - 1);
                    cur = null;
                }else {
                    cur = cur.right;
                }
            }
        }

        return lists;
    }
}
