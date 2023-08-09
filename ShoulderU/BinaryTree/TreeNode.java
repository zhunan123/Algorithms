package ShoulderU.BinaryTree;


public class TreeNode {
    public TreeNode leftChild;
    public boolean data;
    public TreeNode rightChild;
    public int val;
  public TreeNode left;
    public TreeNode right;
   TreeNode() {}
   public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
        this.left = left;
        this.right = right;
    }
}
