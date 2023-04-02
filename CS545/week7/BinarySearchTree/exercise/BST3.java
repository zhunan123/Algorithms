package CS545.week7.BinarySearchTree.exercise;

import java.util.Stack;

public class BST3 {

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

    BST3() {
        root = null;
    }

    public boolean findIterative(int elem) {
        BSTNode current = root;
        while (current != null) {
            if (elem == current.data) {
                System.out.println("true");
                return true;
            } else if (elem < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        System.out.println("false");
        return false;
    }

    public boolean findRecursive(BSTNode root, int elem) {
        if (root == null) {
            System.out.print("false");
            return false;
        }

        if (root.data == elem) {
            System.out.println("true");
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

        if (root == null) {
            root = new BSTNode(elem);
            return;
        }

        //find the node before insertion, prev is the before node
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

    public void insert(int elem) {
        //every time root is over-writing the root after inserting
        root = insertRecursive(root, elem);
    }

    private BSTNode insertRecursive(BSTNode root, int elem) {
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
        if (root != null) {
            System.out.print(root.data + " ");
            printPreOrder(root.left);
            printPreOrder(root.right);
        } else {
            System.out.print(")");
        }
    }

    public void printPreOrderIterative(BSTNode root) {
        if (root == null){
            System.out.println("Nothing to print");
        } else {
            Stack<BSTNode> stack = new Stack<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                BSTNode top = stack.pop();
                System.out.print(top.data + " ");
                if (top.right != null) {
                    stack.push(top.right);
                }
                if (top.left != null) {
                    stack.push(top.left);
                }
            }
        }
    }

    public void printPostOrder(BSTNode root) {
        if (root != null) {
            printPostOrder(root.left);
            printPostOrder(root.right);
            System.out.print(root.data + " ");
        } else {
            System.out.print(")");
        }
    }

    public void printPostOrderIterative(BSTNode root) {
        if (root == null) {
            System.out.print("nothing to print");
        } else {
            Stack<BSTNode> stack = new Stack<>();
            BSTNode current = root;
            while (current != null || !stack.isEmpty()) {
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
    }

    public void printInOrder(BSTNode root) {
        if (root != null) {
            printInOrder(root.left);
            System.out.print(root.data + " ");
            printInOrder(root.right);
        } else {
            System.out.print(")");
        }
    }

    public void printInOrderIterative(BSTNode root) {
       if (root == null) {
           return;
       }
       Stack<BSTNode> stack = new Stack<>();
       while (true) {
           if (root != null) {
               stack.push(root);
               root = root.left;
           } else {
               if (stack.isEmpty()){
                   break;
               }
               root = stack.pop();
               System.out.print(root.data + " ");
               root = root.right;
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

    public int height2(BSTNode root) {
        if (root == null) {
            return 0;
        }

        int maxH = 0;
        for (int i = 0; i < 2; i++) {
            int currH = height2(root.children[i]);
            if (currH > maxH) {
                maxH = currH;
            }
        }
        return maxH + 1;
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

    public BSTNode delete(BSTNode root, int elem) {
        if (root == null) {
            return null;
        }

        if (elem == root.data) {
            if (root.right == null) {
                return root.left;
            } else if (root.left == null) {
                return root.right;
            } else {
                //did not in first pass
                if (root.right.left == null) {
                    root.data = root.right.data;
                    root.right = root.right.right;
                    return root;

                } else {
                    // need to find in second pass
                    root.data = findAndRemoveSmallest(root.right);
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

    public int findAndRemoveSmallest(BSTNode root) {
        if (root.left.left == null) {
            int smallest = root.left.data;
            root.left = root.left.right;
            return smallest;
        } else {
            return findAndRemoveSmallest(root.left);
        }
    }

    public static void main(String[] args) {
        BST3 tree = new BST3();
//        tree.insertIterative(17);
//        tree.insertIterative(8);
//        tree.insertIterative(6);
//        tree.insertIterative(10);
//        tree.insertIterative(3);
//        tree.insertIterative(5);
//        tree.insertIterative(9);
//        tree.insertIterative(11);
//        tree.insertIterative(25);
//        tree.insertIterative(100);

        tree.insert(17);
        tree.insert(8);
        tree.insert(6);
        tree.insert(10);
        tree.insert(3);
        tree.insert(5);
        tree.insert(9);
        tree.insert(11);
        tree.insert(13);
        tree.insert(25);
        tree.insert(100);

//        tree.printPreOrder(tree.root);
//        tree.printPreOrderIterative(tree.root);
//        tree.printPostOrder(tree.root);
        tree.printPostOrderIterative(tree.root);
        System.out.println();
        tree.printInOrder(tree.root);
        System.out.println();
        tree.printInOrderIterative(tree.root);
        System.out.println();
        int count = tree.countBSTNode(tree.root);
        System.out.println(count);
        int height = tree.height(tree.root);
        System.out.println(height);
        int leaf = tree.countLeaf(tree.root);
        System.out.println(leaf);
        tree.findIterative(9);
        tree.findRecursive(tree.root, 2);
    }

}
