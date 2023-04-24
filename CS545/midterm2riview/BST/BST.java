package CS545.midterm2riview.BST;

import CS545.week6.queue.ImplementQueueUsingLinkedList;
import CS545.week7.BinarySearchTree.exercise.BST2;
import CS545.week7.BinarySearchTree.exercise.BST4;

import java.util.Stack;

public class BST {

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

    BST() {
        root = null;
    }

    public boolean findIterative(int elem) {

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

        if (root == null) {
            root = new BSTNode(elem);
            return;
        }

        BSTNode prev = null;
        BSTNode current = root;

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
            root.left =  insertRecursive(root.left, elem);
            return root;
        } else {
            root.right = insertRecursive(root.right, elem);
            return root;
        }
    }

    public void printPreOrder(BSTNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            printPreOrder(root.left);
            printPreOrder(root.right);
        } else {
            System.out.print("/");
        }
    }

    public void printPreOrderIterative(BSTNode root) {
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

    public void printInOrderIterative(BSTNode root) {

        Stack<BSTNode> stack = new Stack<>();
        BSTNode current = root;

        while (true) {
            if (current  != null) {
                stack.push(current );
                current  = current.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                } else {
                    current = stack.pop();
                    System.out.print(current.data + " ");
                    current = current.right;
                }
            }
        }

    }

    public void printTreeByLevel(BSTNode root) {
        ImplementQueueUsingLinkedList queue = new ImplementQueueUsingLinkedList();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            BSTNode temp = (BSTNode) queue.dequeue();
            System.out.print(temp + " ");
            if (temp.left != null) {
                queue.enqueue(temp.left);
            }
            if (temp.right != null) {
                queue.enqueue(temp.right);
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

        return sum(root.left) + sum(root.right);
    }

    public boolean checkSymmetrical(BSTNode root1, BSTNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.data != root2.data) {
            return false;
        }

        return checkSymmetrical(root1.left, root2.right) && checkSymmetrical(root1.right, root2.left);
    }

    public BSTNode delete(BSTNode root, int elem) {
        if (root == null) {
            return null;
        }

        if (elem == root.data) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                if (root.right.left == null) {
                    root.data = root.right.data;
                    root.right = root.right.right;
                    return root;
                } else {
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
            root.left = smallest.right;
            return smallest.data;
        } else {
            return findAndDeletedSmallest(root.left);
        }
    }
}
