package ShoulderU.BFSDFS.june24;

import java.util.List;

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

public class CloneNaryTree1490 {
  public Node cloneTree(Node root) {
    //创建以当前root node为节点的node, recursively call cloneTree to add all child node of the original root to copied node list
    // base case
    if (root == null) {
      return root;
    }
    //创建以当前root node为节点的node
    Node CopiedNode = new Node(root.val);

    //recursive case
    //recursively call all child node and add to copyied node list
    for (Node child : root.children){
      CopiedNode.children.add(cloneTree(child));
    }

    return CopiedNode;
  }
}
