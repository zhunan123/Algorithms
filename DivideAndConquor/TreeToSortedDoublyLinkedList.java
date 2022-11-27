package DivideAndConquor;

public class TreeToSortedDoublyLinkedList {

    /**
     * 将BST转换为已排序的循环双向链表。可以将左右指针视为双向链表中上一个和下一个指针的同义词。
     * 我们以下面的BST为例，它可以帮助您更好地理解问题：
     * bstdlloriginalbst
     * 我们希望将此BST转换为循环双向链表。双向链表中的每个节点都有一个前任和后继。对于循环双向链表，第一个元素的前导是最后一个元素，最后一个元素的后继是第一个元素。
     * 下图显示了上述BST的循环双向链表。“head”符号表示它指向的节点是链表的最小元素。
     *
     * 输入: {4,2,5,1,3}
     *         4
     *        /  \
     *       2   5
     *      / \
     *     1   3
     * 输出: "left:1->5->4->3->2  right:1->2->3->4->5"
     * 解释:
     * left：逆序输出
     * right：正序输出
     * 样例 2:
     *
     * 输入: {2,1,3}
     *         2
     *        /  \
     *       1   3
     * 输出: "left:1->3->2  right:1->2->3"
     *
     * 方法：递归
     * 算法
     * 标准的中序遍历采用 左 -> 根 -> 右 的顺序，其中 左 和 右 的部分调用递归。
     * 本题的处理在于将前一个结点与当前结点链接，因此，必须跟踪最后一个结点，该结点在新的双向链表中是当前最大的。
     * 另外一个细节：我们也需要保留第一个，也就是最小的结点，以完成闭环。
     *
     * 下面是具体算法：
     *
     * 将 first 和 last 结点 初始化为 null。
     * 调用标准中序遍历 helper(root) :
     * 若结点不为 null :
     * 调用左子树递归 helper(node.left)。
     * 若 last 结点不为空，将 last 与当前的 node 链接。
     * 否则初始化 first 结点。
     * 将当前结点标记为最后 : last = node.
     * 调用右子树递归 helper(node.right)。
     * 将最前与最后的结点链接完成闭环，返回 first 。
     * */

    class Solution {
        // the smallest (first) and the largest (last) nodes
        TreeNode first = null;
        TreeNode last = null;

        public void helper(TreeNode node) {
            if (node != null) {
                // left
                helper(node.left);
                // node
                if (last != null) {
                    // link the previous node (last)
                    // with the current one (node)
                    last.right = node;
                    node.left = last;
                }
                else {
                    // keep the smallest node
                    // to close DLL later on
                    first = node;
                }
                last = node;
                // right
                helper(node.right);
            }
        }

        public TreeNode treeToDoublyList(TreeNode root) {
            if (root == null) return null;

            helper(root);
            // close DLL
            last.right = first;
            first.left = last;
            return first;
        }
    }
}
