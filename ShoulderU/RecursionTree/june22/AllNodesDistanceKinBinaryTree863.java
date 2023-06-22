package ShoulderU.RecursionTree.june22;

import ShoulderU.Tree.TreeNode;

import java.util.*;

public class AllNodesDistanceKinBinaryTree863 {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // use BFS
        List<Integer> res = new ArrayList<>();
        // edge case when k = 0
        if (k == 0) {
            res.add(target.val);
            return res;
        }

        // convert tree to graph so we can use visited us Map, key is the starting treeNode, value is the list contains all treeNode we can traverse that is not visited
        Map<TreeNode, List<TreeNode>> map = new HashMap<>();
        // build the bi-directional graph using map where we have a starting treenode ----> [treeNode1, treeNode2, ......](all the treeNode in the list that we can traverse from starting treeNode)
        preorder(map, root);

        Deque<TreeNode> queue = new ArrayDeque<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.add(target);
        // start the while loop, 一圈一圈加进来，5是target node的话，第一圈就是6，2，3 第二圈就是1，7，4，每次remove掉一圈，k--然后当k =0 剩下的最后一圈TreeNode，就是答案
        while (!queue.isEmpty()) {
            int size = queue.size();
            k--;
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.removeFirst();
                visited.add(current);

                List<TreeNode> treeNodeList = map.get(current);
                if (treeNodeList == null) {
                    continue;
                }
                for (TreeNode node : treeNodeList) {
                    // use the visited hashset, if the TreeNode is already added by other treeNode dont add it again
                    // only add the TreeNode if not being visited yet
                    if (!visited.contains(node)) {
                        queue.addLast(node);
                    }
                }

            }
            if (k == 0) {
                for (TreeNode node : queue) {
                    res.add(node.val);
                }
            }
        }
        return res;
    }

    public void preorder(Map<TreeNode, List<TreeNode>> map, TreeNode root) {
        if (root == null) {
            return;
        }

        // build the graph on map
        if (root.left != null) {
            // only add starting point without duplicates, so we use putIfAbsent, so if key is already existed, we dont add
            // 把root 的treenode list 作为第一个key val pair加进map
            // 把root.left 做为starting point的treenode list 作为第二个key val pair加进去map
            map.putIfAbsent(root, new ArrayList<>());
            map.putIfAbsent(root.left, new ArrayList<>());

            // 互相加，把root.left 加到root的treenode list里面，同时把root加到root.left 的treenode list里面，然后就可以实现双边遍历
            map.get(root).add(root.left);
            map.get(root.left).add(root);
        }
        if (root.right != null) {
            map.putIfAbsent(root, new ArrayList<>());
            map.putIfAbsent(root.right, new ArrayList<>());

            map.get(root).add(root.right);
            map.get(root.right).add(root);
        }

        preorder(map, root.left);
        preorder(map, root.right);
    }
}
