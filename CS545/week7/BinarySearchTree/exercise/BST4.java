package CS545.week7.BinarySearchTree.exercise;

import java.util.Stack;

public class BST4 {

  private class BSTNode {
    public BSTNode[] children;
    int data;
    BSTNode left;
    BSTNode right;

    BSTNode(int newdata) {
      data = newdata;
    }
  }

  private BSTNode root;

  BST4() {
    root = null;
  }

  public boolean findIterative(int elem) {
    if (root == null) {
      return false;
    }
    BSTNode current = root;

    //iterative method need this while loop
    while (current != null) {
      if (current.data == elem) {
        return true;
      } else if (elem < current.data) {
        current = current.left;
      } else {
        current = current.right;
      }
    }
    return false;
  }


  public boolean findRecursive(BSTNode root, int elem) {
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

  public void insertIterative(int elem) {
    BSTNode prev = null;
    BSTNode current = root;

    //need to handle root is empty case
    if (root == null) {
      root = new BSTNode(elem);
      return;
    }

    while (current != null) {
      if (elem < current.data) {
        prev = current;
        current = current.left;
      } else {
        prev = current;
        current = current.right;
      }
    }

    if (elem < prev.data) {
      prev.left = new BSTNode(elem);
    } else {
      prev.right = new BSTNode(elem);
    }
  }

  public BSTNode insertRecursive(BSTNode root, int elem) {
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

  public void printPreOrder(BSTNode root) {
//    if (root == null) {
//      return;
//    }

    if (root != null) {
      System.out.print(root.data + " ");
      printPreOrder(root.left);
      printPreOrder(root.right);
    } else {
      System.out.print(")");
    }
  }

  public void printPreOrderIterative(BSTNode root) {
    if (root == null) {
      return;
    }

    Stack<BSTNode> stack = new Stack<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      root = stack.pop();
      System.out.println(root.data + " ");
      if (root.right != null) {
        stack.push(root.right);
      }
      if (root.left != null) {
        stack.push(root.left);
      }
    }
  }

  public void printInOrderIterative(BSTNode root) {
    if (root == null) {
      return;
    }
    Stack<BSTNode> stack = new Stack<>();
    BSTNode current = root;

    while (true) {
      if (current != null) {
        stack.push(current);
        current = current.left;
      }
      //已经走到最左，现在要看该node的右侧是否为空
       else {
         //如今stack top是root，因为root.left 没有，所以现在就是print root
        //然后再去右边
        //想下三个点怎么走的流程
        if (stack.isEmpty()) {
          break;
        }
         current = stack.pop();
         System.out.print(current.data + " ");
         current = current.right;
      }
    }
  }

  public int countBSTNode(BSTNode root) {
    if (root == null) {
      return 0;
    }

    int count = countBSTNode(root.left) + countBSTNode(root.right);
    return count + 1;
  }

  public int height(BSTNode root) {
    if (root == null) {
      return 0;
    }

    int height = Math.max(height(root.left), height(root.right));
//    int maxH = 0;
//    for (int i = 0; i < 2; i++) {
//      int currH = height(root.children[i]);
//      if (currH > maxH){
//        maxH = currH;
//      }
//    }

    return height + 1;
  }

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

  public int sum(BSTNode root) {
    if (root == null) {
      return 0;
    }

    int sum = sum(root.left) + sum(root.right);
    return sum + root.data;
  }

  public int leafSum(BSTNode root) {
    if (root == null) {
      return 0;
    }
    if (root.left == null && root.right == null) {
      return root.data;
    }

    int sum = leafSum(root.left) + leafSum(root.right);

    return sum;
  }

  public BSTNode delete(BSTNode root, int elem) {
    if (root == null) {
      return null;
    }
    if (root.data == elem) {
      //three condition, first two condition dont need to swap with the smallest in the right hand side
      if (root.right == null) {
        return root.left;
      } else if (root.left == null) {
        return root.right;
      } else {
        //3rd condition have both child. did find smallest directly.
        if (root.right.left == null) {
          root.data = root.right.data;
          root.right = root.right.right;
          return root;
        } else {
          // did not find it directly
          root.data = findAndDeletedSmallest(root.right);
          return root;
        }
      }

    } else if (elem < root.data) {
      root.left = delete(root.left, elem);
      return root;
    } else {
      root.right = delete(root.right, elem);
      return root;
    }
  }

  public int findAndDeletedSmallest(BSTNode root) {
    if (root.left.left == null) {
      BSTNode smallest = root.left;
      root.left = root.left.right;
      return smallest.data;
    } else {
      //只用return这个就行
      //recursive case
      return findAndDeletedSmallest(root.left);
    }
  }
}
