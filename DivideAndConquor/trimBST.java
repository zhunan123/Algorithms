package DivideAndConquor;

public class trimBST {

    /**
     * 输入：
     * {8,3,10,1,6,#,14,#,#,4,7,13}
     * 5
     * 13
     * 输出： {8, 6, 10, #, 7, #, 13}
     * 说明：树的图片在题面描述里已经给出
     * */

    public TreeNode trimBST(TreeNode root, int minimum, int maximum) {
        // write your code here
        if (root == null) {
            return null;
        }

        int rootval = root.val;
        if (rootval >= minimum && rootval <= maximum) {
            root.left = trimBST(root.left, minimum, rootval);
            root.right = trimBST(root.right, rootval, maximum);
            return root;
        } else if (rootval < minimum) {
            return trimBST(root.right, minimum, maximum);
        } else {
            return trimBST(root.left, minimum, maximum);
        }
    }
}
