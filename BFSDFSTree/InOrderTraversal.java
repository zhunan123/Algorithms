package BFSDFSTree;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {
   /**
    * 输入
    * 二叉树 = {1,2,3}
    * 输出：
    * [2,1,3]
    * 解释：
    *
    *       1
    *     /   \
    *   2       3
    * */

   public List<Integer> inorderTraversal(TreeNode root) {
       List<Integer> res = new ArrayList<Integer>();
       inOrder(root, res);
       return res;
   }

    public void inOrder(TreeNode root, List<Integer> res){
        if (root == null) {
            return;
        }
        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
    }
}