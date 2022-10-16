public class FindAllBinaryTreePathUsingDFSRecursion {
    /**
     * 输入：{1,2,3,#,5}
     * 输出：["1->2->5","1->3"]
     * 解释：
     *    1
     *  /   \
     * 2     3
     *  \
     *   5
     * */
    public List<String> binaryTreePaths(TreeNode root) {

        List<String> pathLists = new ArrayList<String>();
        constructPath(root, "", pathLists);
        return pathLists;
    }
    public void constructPath(TreeNode root, String path, List<String> pathLists) {
        if (root != null) {
            StringBuffer sb = new StringBuffer(path);
            sb.append(Integer.toString(root.val));
            if (root.left == null && root.right == null){
                pathLists.add(sb.toString());
            }else {
                sb.append("->");
                //这里就是利用DFS递归去遍历整个tree
                constructPath(root.left, sb.toString(), pathLists);
                constructPath(root.right, sb.toString(), pathLists);
            }
        }
    }
}