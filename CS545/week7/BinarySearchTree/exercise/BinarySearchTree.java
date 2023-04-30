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

    BSTNode root;

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
            System.out.println("false");
            return false;
        }
        //recursive case
        if (elem == root.data) {
            System.out.println("true");
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
                    //本来已经是最左边了，没有左边。同时也没有右边的话，就说明只有根了
                    //就print根
                    temp = stack.pop();
                    System.out.print(temp.data + " ");
                    //check if temp is stack.peek().right
                    //看刚才popped的temp/下一层根是不是现在/上一层stack top的right
                    //如果是上一层top的right就是刚才的temp，说明上一层root的左右根都print了, 要不就是无
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
    public BSTNode delete(BSTNode root, int elem) {
        if (root == null) {
            return null;
        }

        if (root.data == elem) {
            if (root.left == null) {
                //笔记上有记录
                return root.right;
            }
            if (root.right == null) {
                //笔记上有记录
                return root.left;
            }

            if (root.right.left == null) {
                root.data = root.right.data;
                root.right = root.right.right;
                return root;

            } else {
                root.data = findAndRemovedSmallest(root.right);
                return root;
            }

        } else if (elem < root.data) {
            root.left = delete(root.left, elem);
            return root;
        } else {
            root.right = delete(root.right, elem);
            return root;
        }
    }

    //remove smallest on the right side
    private int findAndRemovedSmallest(BSTNode root) {
        if (root.left.left == null) {
            int smallest = root.left.data;
            root.left = root.left.right;
            return smallest;
        } else {
            return findAndRemovedSmallest(root.left);
        }
    }
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insertIterative(17);
        tree.insertIterative(8);
        tree.insertIterative(5);
        tree.insertIterative(10);
        tree.insertIterative(25);
        tree.insertIterative(100);

//        tree.findIterative(12);

        tree.printPreOrder(tree.root);
//        System.out.println("");
//        tree.printPostOrder(tree.root);
//        tree.preOrderIterative(tree.root);
//        tree.printPostOrderTraversalIterative(tree.root);
//        int count = tree.countBSTNode(tree.root);
//        int height = tree.findBSTHeight(tree.root);
//        int count = tree.countLeafNodes(tree.root);
//        int sum = getSumOfAllNode(tree.root);
//        tree.findRecursive(tree.root, 26);
//        tree.delete(tree.root, 8);
//        tree.printPostOrder(tree.root);
    }

}
