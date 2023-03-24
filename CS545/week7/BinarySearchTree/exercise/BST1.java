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
        return false;
    }


    //find recursive
    public boolean findRecursive(BSTNode root, int elem) {
        //use base call root null and elem = root.data
        //recursive case
        //base case

        //recursive case
        return false;
    }


    //insert recursive, need to build the entire tree;
    public BSTNode insertRecursive(BSTNode root, int elem) {
        //base condition is root = null
        //recursive case is build the enitre tree
        return null;
    }

    //insert iterative
    public void insertIterative(int elem) {

        //edge condition

        //You can only use return without any expression following it in a void method.
        // It serves as an immediate termination point for the method.

        //find previous node

        //implement insert
    }

    //print pre-order recursive
    public void printPreOrder(BSTNode root) {

    }

    //print pre-order iterative
    public void preOrderIterative(BSTNode root) {

    }

    //print post-order recursive
    public void printPostOrder(BSTNode root) {

    }
    //print post-order iterative

    //count BST nodes

    //find BST heights

    //count leaves

    //sum of all nodes

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
        tree.insertIterative(11);
        tree.insertIterative(25);
        tree.insertIterative(100);

        tree.findIterative(12);

//        tree.printPreOrder(tree.root);
//        System.out.println("");
//        tree.printPostOrder(tree.root);
//        tree.preOrderIterative(tree.root);
    }

}
