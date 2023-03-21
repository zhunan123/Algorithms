package CS545.week7.BinarySearchTree;

public class BinarySearchTree {

  private class BSTNode {
    int data;
    BSTNode left;
    BSTNode right;

    BSTNode(int newdata) {
      data = newdata;
    }
  }

  public static BSTNode root;

  //recursively find if elem exist in BST
  //worst case O(n) when its chain have unbalanced BST,
  //best case o(logn)—when have balanced BST
  public boolean find(BSTNode tree, int elem) {
    //base case
    if (tree == null) {
      return false;
    }
    if (tree.data == elem) {
      return true;
    }
    //recursive case
    if (elem < tree.data) {
      return find(tree.left, elem);
    } else {
      return find(tree.right, elem);
    }
  }

  //interatively insert elem in to tree
  public void insertIterative(int elem) {
    BSTNode prev = null;
    BSTNode current = root;
    //edge case
    if (root == null) {
      root = new BSTNode(elem);
      return;
    }
    //find prev node to insert
    while (current != null) {
      if (elem >= current.data) {
        prev = current;
        current = current.right;
      } else {
        prev = current;
        current = current.left;
      }
    }
    //actual insert the element
    if (elem >= prev.data) {
      prev.right = new BSTNode(elem);
    } else {
      prev.left = new BSTNode(elem);
    }
  }

  public BSTNode insertNodeRecursively(BSTNode tree, int elem) {
    //base case
    if (tree == null) {
      return new BSTNode(elem);
    }
    //recursively case
    if (elem > tree.data) {
      tree.right = insertNodeRecursively(tree.right, elem);
      return tree;
    } else {
      tree.left = insertNodeRecursively(tree.left, elem);
      return tree;
    }
  }

  public void printPreorder(BSTNode tree) {
    if (tree != null) {
      System.out.print(" " + tree.data + " ");
      printPreorder(tree.left);
      printPreorder(tree.right);
    } else {
      System.out.print("/");
    }
  }


  public static void main(String[] args) {
    BinarySearchTree tree = new BinarySearchTree();
//        tree.insert(14);
//        tree.insert(3);
//        tree.insert(25);
//        tree.insert(6);
//        tree.insert(1);
//        tree.printPreorder();
//        System.out.println();
    tree.insertIterative(7);
    tree.insertIterative(3);
    tree.insertIterative(1);
    tree.insertIterative(10);
    tree.printPreorder(root);


  }
}
