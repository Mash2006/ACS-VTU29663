import java.util.*;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        backtrack(root, targetSum, path, result);

        return result;
    }

    private void backtrack(TreeNode root, int target,
                            List<Integer> path,
                            List<List<Integer>> result) {

        if (root == null) {
            return;
        }

        path.add(root.val);
        target -= root.val;

        if (root.left == null &&
            root.right == null &&
            target == 0) {

            result.add(new ArrayList<>(path));
        }

        backtrack(root.left, target, path, result);
        backtrack(root.right, target, path, result);

        path.remove(path.size() - 1);
    }
}
