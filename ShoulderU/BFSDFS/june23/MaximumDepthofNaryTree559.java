package ShoulderU.BFSDFS.june23;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class MaximumDepthofNaryTree559 {
    public int maxDepth(Node root) {
        // define edge case
        if (root == null) {
            return 0;
        }
        // use queue to BFS
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int height = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                if (current == null) {
                    continue;
                }
                List<Node> childrenNodes = current.children;
                if (childrenNodes != null) {
                    for (Node node : childrenNodes) {
                        queue.add(node);
                    }
                }
            }
            height++;
        }
        return height;
    }
}
