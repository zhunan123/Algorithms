package ShoulderU.backtrack.may29;

import ShoulderU.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();

        dfs(result, "", root);
        return result;
    }

    public void dfs(List<String> result, String path, TreeNode root) {
        if (root != null) {
            path += String.valueOf(root.val); // add current integer into path

            // base case
            if (root.left == null && root.right == null) {
                result.add(path);
                return;
            }

            //recursive case
            path += "->";
            dfs(result, path, root.left);
            dfs(result, path, root.right);
        }
    }
}
