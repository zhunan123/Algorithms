package CS545.week7.BinarySearchTree.exercise;

import java.util.Stack;

public class BST1 {

    private class BSTNode {
        int data;
        BSTNode left;
        BSTNode right;

        BSTNode(int newdata) {
            data = newdata;
        }
    }

    private BSTNode root;

    BST1() {
        root = null;
    }

    //find iterative
    public boolean findIterative(int elem) {
        //use current and while and three if condition
       BSTNode current = root;
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


    //find recursive
    public boolean findRecursive(BSTNode root, int elem) {
        //use base call root null
        //recursive case and elem = root.data
        //base case
        if (root == null) {
            return false;
        }
        //recursive case
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
            System.out.print("/");
        }

    }

    //print pre-order iterative
    public void preOrderIterative(BSTNode root) {
        if (root != null) {
            Stack<BSTNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
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
        BSTNode current = root;
        Stack<BSTNode> stack = new Stack<>();

        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                BSTNode temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.pop();
                    System.out.print(temp.data + " ");
                    //如果刚才pop的elem就是上一层stack top的right，说明左右都print了，就只差最后root要print
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
        } else {
            System.out.print("/");
        }

    }

    public void inOrderIterative(BSTNode root) {
        if (root == null) {
            return;
        }
        Stack<BSTNode> stack = new Stack<>();
        while(true) {
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

        return countLeaf(root.left) + countLeaf(root.right);
    }

    //sum of all nodes
    public int sumOfAllNodes(BSTNode root) {
        if (root == null) {
            return 0;
        }

        return root.data + sumOfAllNodes(root.left) + sumOfAllNodes(root.right);
    }

    //delete

    //remove smallest on the right side

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insertIterative(17);
        tree.insertIterative(8);
        tree.insertIterative(5);
        tree.insertIterative(10);
        tree.insertIterative(25);
        tree.insertIterative(100);

        tree.findIterative(12);

//        tree.printPreOrder(tree.root);
//        System.out.println("");
//        tree.printPostOrder(tree.root);
        tree.preOrderIterative(tree.root);

//        int count = tree.countBSTNode(tree.root);
//        System.out.println(count);
//        int height = tree.findBSTHeight(tree.root);
//        int count = tree.countLeafNodes(tree.root);
//        int sum = getSumOfAllNode(tree.root);
    }

}
