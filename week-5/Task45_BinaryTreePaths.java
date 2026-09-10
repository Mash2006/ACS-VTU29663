import java.util.*;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();

        buildPaths(root, "", result);

        return result;
    }

    private void buildPaths(TreeNode root,
                            String path,
                            List<String> result) {

        if (root == null) {
            return;
        }

        String currentPath;

        if (path.isEmpty()) {
            currentPath = String.valueOf(root.val);
        } else {
            currentPath = path + "->" + root.val;
        }

        if (root.left == null && root.right == null) {
            result.add(currentPath);
            return;
        }

        buildPaths(root.left, currentPath, result);
        buildPaths(root.right, currentPath, result);
    }
}
