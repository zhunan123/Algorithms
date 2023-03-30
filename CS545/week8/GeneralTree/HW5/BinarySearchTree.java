package CS545.week8.GeneralTree.HW5;

public class BinarySearchTree {
  private BinarySearchTreeNode root; // the root of the tree

  /**
   * An inner class representing a node in a BST tree
   */
  private class BinarySearchTreeNode {
    public int data; // value stored at the node
    public BinarySearchTreeNode left; // left subtree
    public BinarySearchTreeNode right;  // right subtree

    BinarySearchTreeNode(int newdata) {
      data = newdata;
    }
  }

  /** Creates a node with the given element and insert it into the binary search tree
   *
   * @param elem element to insert
   */
  public void insertIterative(int elem) {
    BinarySearchTreeNode prev = null;
    BinarySearchTreeNode current = root;
    if (root == null) {
      root = new BinarySearchTreeNode(elem);
      return;
    }
    while (current != null) {
      if (elem >= current.data) {
        prev = current;
        current = current.right;
      }
      else {
        prev = current;
        current = current.left;
      }
    }
    if (elem < prev.data) {
      prev.left = new BinarySearchTreeNode(elem);
    }
    else {
      prev.right = new BinarySearchTreeNode(elem);
    }
  }


  /** A public method that produces a serialization of this tree */
  public void serializeUsingPreorder() {
    serializeUsingPreorder(root);
  }

  /** Serialize a given tree using preorder traversal
   *  using / as a sentinel character
   * @param tree
   */
  private void serializeUsingPreorder(BinarySearchTreeNode tree) {
    if (tree != null) {
      System.out.print(" " + tree.data + " ");
      serializeUsingPreorder(tree.left);
      serializeUsingPreorder(tree.right);
    } else
      System.out.print("/");
  }

  /**
   * Delete a node with the given element. Must be NON-recursive.
   * @param elem element to delete
   */
  public void deleteIterative(int elem) {
    if (root == null) { // nothing to delete
      return;
    }
    BinarySearchTreeNode prev = null;
    BinarySearchTreeNode current = root;

    // First, find current that contains the elem value
    while (current != null) {
      if (elem == current.data)
        break;
      // FILL IN CODE
      if (elem < current.data) {
        prev = current;
        current = current.left;
      } else {
        prev = current;
        current = current.right;
      }

    }
    if (current == null)
      return; // element not in the tree, nothing to delete

    // Found the value we need to delete:
    System.out.println("Node to delete: " + current.data);

    // FILL IN CODE: delete the node if one or both of the children are null
    if (current.left == null) {
      // FILL IN CODE
      if (elem < prev.data) {
        prev.left = current.right;
      } else {
        prev.right = current.right;
      }
    }
    else if (current.right == null){
      // FILL IN CODE
      if (elem < prev.data) {
        prev.left = current.left;
      } else {
        prev.right = current.left;
      }
    }
    else { // has both children
      // Find the smallest value in the right subtree
      BinarySearchTreeNode rightRoot = current.right;
      BinarySearchTreeNode prevBeforeRightRoot = current;
      // FILL IN CODE: find the smallest value in the right subtree
      while (rightRoot.left != null) {
        prevBeforeRightRoot = rightRoot;
        rightRoot = rightRoot.left;
      }
      BinarySearchTreeNode smallest = rightRoot;

      System.out.println("smallest in the right subtree " + rightRoot.data);

      // FILL IN CODE: swap smallest with current.data
      current.data = smallest.data;

      // FILL IN CODE: Remove the node that used to be the "smallest"
      //rightRoot.left == null but rightRoot.right can be null or can be not null, need to connect the not null part if rightroot.right != null.
      prevBeforeRightRoot.left = rightRoot.right;
    }
  }

  public void deleteIterative2(int item) {
    BinarySearchTreeNode prev = null;
    BinarySearchTreeNode current = root;

    while (current != null) {
      if (current.data == item) {
        break;
      } else if (item < current.data) {
        prev = current;
        current = current.left;
      } else {
        prev = current;
        current = current.right;
      }
    }

    if (current == null) {
      return;
    }
    System.out.println("The item need to be deleted is: " + current.data);

    BinarySearchTreeNode nodeBeforeRightRoot = null;
    BinarySearchTreeNode rightRoot = current.right;

    while (rightRoot.left != null) {
      nodeBeforeRightRoot = rightRoot;
      rightRoot = rightRoot.left;
    }

    current.data = rightRoot.data;

    nodeBeforeRightRoot.left = rightRoot.right;
  }

}
