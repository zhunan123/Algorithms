package CS545.week7.BinarySearchTree.exercise;

import java.util.Stack;

public class BST2 {

  private class BSTNode {
    int data;
    BSTNode left;
    BSTNode right;

    BSTNode(int newdata) {
      data = newdata;
    }
  }

  private BSTNode root;

  BST2() {
    root = null;
  }

  //find iterative
  public boolean findIterative(int elem) {
    //use current and while and three if condition
    if (root == null) {
      return false;
    }

    while (root != null) {
      if (root.data == elem) {
        return true;
      } else if (elem < root.data) {
        root = root.left;
      } else {
        root = root.right;
      }
    }
    return false;
  }


  //find recursive
  public boolean findRecursive(BSTNode root, int elem) {
    //use base call root null
    //recursive case and elem = root.data

    if (root == null) {
      return false;
    }

    if (root.data == elem) {
      return true;
    } else if (elem < root.data) {
      return findRecursive(root.left, elem);
    } else {
      return findRecursive(root.right, elem);
    }
  }


  //insert recursive, need to build the entire tree;
  public BSTNode insertRecursive(BSTNode root, int elem) {
    //base condition is root = null
    //recursive case is build the enitre tree

    if (root == null) {
      root = new BSTNode(elem);
      return root;
    }

    if (elem < root.data) {
      root.left = insertRecursive(root.left, elem);
      return root;
    } else {
      root.right = insertRecursive(root.right, elem);
      return root;
    }

  }

  //insert iterative
  public void insertIterative(int elem) {
    BSTNode prev = null;
    BSTNode current = root;

    //edge condition
    if (root == null) {
      root = new BSTNode(elem);
      return;
    }
    //You can only use return without any expression following it in a void method.
    // It serves as an immediate termination point for the method.

    //find previous node
    while (current != null) {
      if (elem < current.data) {
        prev = current;
        current = current.left;
      } else {
        prev = current;
        current = current.right;
      }
    }

    //implement insert
    if (elem < prev.data) {
      prev.left = new BSTNode(elem);
    } else {
      prev.right = new BSTNode(elem);
    }

  }

  //print pre-order recursive
  public void printPreOrder(BSTNode root) {
    if (root != null) {
      System.out.print(root.data + " ");
      printPreOrder(root.left);
      printPreOrder(root.right);
    } else {
      System.out.print("/" + " ");
    }

  }

  //print pre-order iterative
  public void preOrderIterative(BSTNode root) {
    //思路：先建一个stack，stack push root,
    //while loop stack 不是empty
    //pop stack top 并赋值temp
    //先push temp right，再push temp left
    if (root != null) {
      Stack<BSTNode> stack = new Stack<>();
      stack.push(root);

      while(!stack.isEmpty()) {
        BSTNode temp = stack.pop();
        System.out.print(temp.data + " ");
        if (temp.right != null) {
          stack.push(temp.right);
        }
        if (temp.left != null) {
          stack.push(temp.left);
        }
      }
    }

  }

  //print post-order recursive
  public void printPostOrder(BSTNode root) {
    if (root != null) {
      printPostOrder(root.left);
      printPostOrder(root.right);
      System.out.print(root.data + " ");
    } else {
      System.out.print("/");
    }
  }
  //print post-order iterative
  public void postOrderIterative(BSTNode root){
    //先设置current是root
    //traverse 到最左边的node，并push traverse 的node进入stack,means这个node没有left
    //设置stack.peek.right 是temp,
    //如果temp是null的话，说明改node无right, else 说明该node有right，就set current = temp
    //pop stack top 然后print
    //如果该temp是pop完temp的stack的right, 继续pop stack，然后print
    BSTNode current = root;
    Stack<BSTNode> stack = new Stack<>();
    while (current != null || !stack.isEmpty()) {
      if (current != null) {
        stack.push(current);
        current = current.left;
      }else {
        BSTNode temp = stack.peek().right;
        if (temp == null) {
          temp = stack.pop();
          System.out.print(temp.data + " ");
          while (!stack.isEmpty() && temp == stack.peek().right) {
            temp = stack.pop();
            System.out.print(temp.data + " ");
          }
        } else {
          current = temp;
        }
      }
    }
  }

  public void printInOrder(BSTNode root) {
    if (root != null) {
      printInOrder(root.left);
      System.out.print(root.data);
      printInOrder(root.right);
    }else {
      System.out.print("/");
    }

  }

  public void inOrderIterative(BSTNode root) {
    if (root == null) {
      return;
    }
    Stack<BSTNode> stack = new Stack<>();
    while (true) {
      if (root != null) {
        stack.push(root);
        root = root.left;
      } else {
        if (stack.isEmpty()) {
          break;
        }
        root = stack.pop();
        System.out.print(root.data);
        root = root.right;
      }
    }
  }

  //count BST nodes
  public int countBSTNode(BSTNode root) {
    if (root == null) {
      return 0;
    }
    int count = countBSTNode(root.left) + countBSTNode(root.right);
    return count + 1;
  }

  //find BST heights
  public int getHeight(BSTNode root) {
    if (root == null) {
      return 0;
    }

    int height = Math.max(getHeight(root.left), getHeight(root.right));
    return height + 1;
  }

  //count leaves
  public int countLeaf(BSTNode root) {
    if (root == null) {
      return 0;
    }

    if (root.left == null && root.right == null) {
      return 1;
    }

    int count = countLeaf(root.left) + countLeaf(root.right);
    return count;
  }


  //sum of all nodes
  public int sumOfAllNodes(BSTNode root) {
    if (root == null) {
      return 0;
    }

    int sum = sumOfAllNodes(root.left) + sumOfAllNodes(root.right);
    return sum + root.data;
  }

  //delete
  public BSTNode delete(BSTNode root, int elem) {
    if (root == null) {
      return null;
    }
    if (root.data == elem) {
      if (root.right == null) {
        return root.left;
      } else if (root.left == null) {
        return root.right;
      } else {
        if (root.right.left == null) {
          root.data = root.right.data;
          root.right = root.right.right;
          return root;
        } else {
          root.data = findAndRemoveSmallest(root.right);
          return root;
        }
      }
    }else if (elem < root.data){
      root.left = delete(root.left, elem);
      return root;
    } else {
      root.right = delete(root.right, elem);
      return root;
    }
  }

  //remove smallest on the right side
  public int findAndRemoveSmallest(BSTNode root) {
    if (root.left.left == null) {
      int smallest = root.left.data;
      root.left = root.left.right;
      return smallest;
    } else {
      return findAndRemoveSmallest(root.left.left);
    }
  }

  public static void main(String[] args) {
    BST2 tree = new BST2();
    tree.insertIterative(17);
    tree.insertIterative(8);
    tree.insertIterative(6);
    tree.insertIterative(10);
    tree.insertIterative(3);
    tree.insertIterative(7);
    tree.insertIterative(9);
    tree.insertIterative(11);
    tree.insertIterative(25);
    tree.insertIterative(100);

    tree.delete(tree.root, 8);



        tree.printPreOrder(tree.root);
//        System.out.println("");
//        tree.printPostOrder(tree.root);
//        tree.preOrderIterative(tree.root);
//    tree.postOrderIterative(tree.root);
//    tree.printInOrder(tree.root);
//    int count = tree.countBSTNode(tree.root);
//    System.out.println(count);
//        int height = tree.findBSTHeight(tree.root);
//        int count = tree.countLeaf(tree.root);
//    System.out.println(count);
//        int sum = getSumOfAllNode(tree.root);
  }
}
