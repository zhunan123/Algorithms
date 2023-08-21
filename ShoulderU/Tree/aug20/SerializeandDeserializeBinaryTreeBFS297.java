package ShoulderU.Tree.aug20;

import ShoulderU.Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeandDeserializeBinaryTreeBFS297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        // ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        // ArrayDeuque is not able to add null value
        Queue<TreeNode> queue = new LinkedList<>();
        // queue.addLast(root);
        queue.offer(root);
        while (!queue.isEmpty()) {
            // TreeNode current = queue.removeFirst();
            TreeNode current = queue.poll();
            if (current == null) {
                sb.append("null");
            } else {
                sb.append(String.valueOf(current.val));
                // queue.addLast(current.left);
                // queue.addLast(current.right);
                // ArrayDeuque is not able to add null value, so cannot use arrayDequeue here
                queue.offer(current.left);
                queue.offer(current.right);
            }
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        String[] arr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (i < arr.length) {
            //root is arr[0], not change, but following nodes is connected so jsut need to return root;
            //1.create parent node, 2.connect parent node with current arr[i] in string array, 3.add children into queue
            TreeNode parent = queue.poll();
            //left
            if (!arr[i].equals("null")) {
                parent.left = new TreeNode(Integer.parseInt(arr[i]));
                queue.offer(parent.left);
            }
            i++;
            //right
            if (!arr[i].equals("null")) {
                parent.right = new TreeNode(Integer.parseInt(arr[i]));
                queue.offer(parent.right);
            }
            i++;
        }
        return root;
    }
}
