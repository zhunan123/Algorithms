package CS545.week7.BinarySearchTree.leetcode;

public class LowestCommonAncestorofaBinarySearchTree {

    /**
     * Given a binary search tree (BST), find the lowest common ancestor (LCA) node
     * of two given nodes in the BST.
     *
     * According to the definition of LCA on Wikipedia: “The lowest common ancestor is
     * defined between two nodes p and q as the lowest node in T that has both p and q as descendants
     * (where we allow a node to be a descendant of itself).”
     *
     *
     *
     * Example 1:
     *
     *
     * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
     * Output: 6
     * Explanation: The LCA of nodes 2 and 8 is 6.
     * Example 2:
     *
     *
     * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
     * Output: 2
     * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself
     * according to the LCA definition.
     * */

    /**
     * min is the min value of 2 treenode, max is the max value of the 2 treenode,
     * 3 condition, if both treenodes are on the left side, then root = root.left,
     * if both treenodes are on the right side, we move root = root.right,
     * last one is the base case, if the one treenode is on the left side of root min <= root,
     * and other treenode on the right side of treenodes max >= root,
     * then we know the lowest common ancestor of these two treenodes will be the root nodes.
     * */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);
        while (root != null) {
            // since we are comparing with root val, so we need to know which treeNode is in left (min), and which treeNode is in right(max)
            //this min.val < root.val && max.val > root.val is the base case;
            if (min <= root.val && max >= root.val) { // thjis is trick condition need to includes (= |equal to root.val)
                //cannot be min < root.val && max > root.val, then will be wrong
                break;
            } else if (min < root.val && max < root.val) {
                root = root.left;
            } else { // p.val > root && q.val > root
                root = root.right;
            }
        }
        return root;
    }
}
