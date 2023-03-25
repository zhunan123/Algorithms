package CS545.week7.BinarySearchTree.exercise;

import java.util.Stack;

public class BinarySearchTree {

    private class BSTNode {
        int data;
        BSTNode left;
        BSTNode right;

        BSTNode(int newdata) {
            data = newdata;
        }
    }

    private BSTNode root;

    BinarySearchTree() {
        root = null;
    }

    //find iterative
    public boolean findIterative(int elem) {
        //use current and while and three if condition
        BSTNode current = root;
        while (current != null) {
            if(current.data == elem) {
                System.out.println("true");
                return true;
            }
            if (elem < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        System.out.println("false");
        return false;
    }


    //find recursive
    public boolean findRecursive(BSTNode root, int elem) {
        //use base call root null and elem = root.data
        //recursive case
        //base case
        if (root == null) {
            return false;
        }
        //recursive case
        if (elem == root.data) {
            return true;
        }
        if (elem < root.data) {
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
            //You can only use return without any expression following it in a void method.
            // It serves as an immediate termination point for the method.
        }
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
            System.out.print("?" + " ");
        }
    }

    //print pre-order iterative
    public void preOrderIterative(BSTNode root) {
        if (root != null) {
            Stack<BSTNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                BSTNode node = stack.pop();
                System.out.print(node.data + " ");
                if (node.left != null) {
                    stack.push(node.left);
                }
                if (node.right != null) {
                    stack.push(node.right);
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
        }
    }
    //print post-order iterative
    public void printPostOrderTraversalIterative(BSTNode root) {
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

    //count BST nodes
    public int countBSTNode(BSTNode root) {
        if (root == null) {
            return 0;
        }
        int count = countBSTNode(root.left) + countBSTNode(root.right);
        return count + 1;
    }

    //find BST heights
    public int findBSTHeight(BSTNode root) {
        if (root == null) {
            return 0;
        }
        int h = Math.max(findBSTHeight(root.left), findBSTHeight(root.right));

        return h + 1;
    }

    //count leaves nodes
    public int countLeafNodes(BSTNode root) {
        if (root == null) {
            return 0;
        }
        if (root.right == null && root.left == null) {
            return 1;
        }

        return countLeafNodes(root.left) + countLeafNodes(root.right);
    }

    //sum of all nodes
    public static int getSumOfAllNode(BSTNode root) {
        if (root == null) {
            return 0;
        }
        int sum = getSumOfAllNode(root.left) + getSumOfAllNode(root.right);

        return root.data + sum;
    }

    //delete

    //remove smallest on the right side

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insertIterative(17);
        tree.insertIterative(8);
        tree.insertIterative(5);
        tree.insertIterative(10);
        tree.insertIterative(3);
        tree.insertIterative(6);
//        tree.insertIterative(4);
        tree.insertIterative(11);
        tree.insertIterative(25);
        tree.insertIterative(100);

        tree.findIterative(12);

//        tree.printPreOrder(tree.root);
//        System.out.println("");
//        tree.printPostOrder(tree.root);
//        tree.preOrderIterative(tree.root);
//        tree.printPostOrderTraversalIterative(tree.root);
//        int count = tree.countBSTNode(tree.root);
//        int height = tree.findBSTHeight(tree.root);
//        int count = tree.countLeafNodes(tree.root);
        int sum = getSumOfAllNode(tree.root);
        System.out.println(sum);
    }

}
