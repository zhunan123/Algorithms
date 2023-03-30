package CS545.week8.GeneralTree.HW5;

public class BinarySearchTreeDriver {
  public static void main(String[] args) {
    BinarySearchTree tree = new BinarySearchTree();
    tree.insertIterative(6);
    tree.insertIterative(1);
    tree.insertIterative(10);
    tree.insertIterative(8);
    tree.insertIterative(12);
    tree.insertIterative(16);
    tree.serializeUsingPreorder();
    System.out.println();
    tree.deleteIterative2(16);
    tree.serializeUsingPreorder(); /* 6  1 // 10  8 // 12 // */
    System.out.println();
    tree.deleteIterative2(6);
    tree.serializeUsingPreorder();  /* 8  1 // 10 / 12 // */
    System.out.println();
    tree.deleteIterative2(10);
    tree.serializeUsingPreorder();  /* 8  1 // 12 // */
    System.out.println();
  }
}
