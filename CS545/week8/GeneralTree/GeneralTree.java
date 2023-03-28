package CS545.week8.GeneralTree;

import CS545.week6.queue.ImplementQueueUsingArray;

public class GeneralTree {

  private class TreeNode {
    int data;
    TreeNode leftChild;
    TreeNode rightChild;
    TreeNode parent;

    TreeNode[] children;

  }

  //general tree in array using BFS

  //general tree in array using DFS
  public int getTreeHeight(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int maxH = 0;
    for (int i = 0; i < root.children.length; i++) {
      int currH = getTreeHeight(root.children[i]);
      if (currH > maxH) {
        maxH = currH;
      }
    }
    return maxH + 1;
  }

  public int getTreeHeight2(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int maxH = 0;
    for (int i = 0; i < root.children.length; i++) {
      int currH = getTreeHeight2(root.children[i]);
      maxH = Math.max(maxH, currH);
    }
    return maxH + 1;
  }

  boolean isLeaf(TreeNode node) {
    //go through each children of this node. if not null, means its not leaf
    for (int i = 0; i < node.children.length; i++) {
      if (node.children[i] != null) {
        return false;
      }
    }
    return true;
  }

  //get number of leaves
  public int countLeaf(TreeNode root) {
    if (root == null) {
      return 0;
    }
    if (isLeaf(root)) {
      return 1;
    }

    int count = 0;
    for (int i = 0; i < root.children.length; i++) {
      int num = countLeaf(root.children[i]);
      count += num;
    }

    return count;
  }

  public int countNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int count = 0;
    for (int i = 0; i < root.children.length; i++) {
      int num = countNodes(root.children[i]);
      count += num;
    }
    return count + 1;
  }

  public int sumOfAllNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int sum = 0;
    for (int i = 0; i < root.children.length; i++) {
      int num = sumOfAllNodes(root.children[i]);
      sum += num;
    }
    return sum + root.data;
  }

  //general tree in Linkedlist
  public int height(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int maxH = 0;
    for (TreeNode curr = root.leftChild; curr != null; curr = curr.rightChild) {
      int currH = height(curr);
      if (currH > maxH) {
        maxH = currH;
      }
    }
    return maxH + 1;
  }

  public int height1(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int maxH = 0;
    TreeNode current = root.leftChild;
    while (current != null) {
      int currH = height1(current);
      if (currH > maxH) {
        maxH = currH;
      }
      current = current.rightChild;
    }
    return maxH + 1;
  }

  //use BFS to traverse and print by level
  private void printByLevel(TreeNode root) {
    ImplementQueueUsingArray q = new ImplementQueueUsingArray();
    q.enqueue(root);

    while (!q.isEmpty()) {
      TreeNode node = (TreeNode) q.dequeue();
      System.out.print(node.data + " ");
      for (TreeNode current = root.leftChild; current != null; current = current.rightChild) {
        q.enqueue(current);
      }
    }
  }

  private void printByLevel2(TreeNode root) {
    ImplementQueueUsingArray q = new ImplementQueueUsingArray();
    q.enqueue(root);

    while (!q.isEmpty()) {
      TreeNode node = (TreeNode) q.dequeue();
      System.out.print(node.data + " ");

      TreeNode current = root.leftChild;
      while (current != null) {
        q.enqueue(current);
        current = current.rightChild;
      }
    }
  }
  private void printPreorder(TreeNode root) {

  }

}
