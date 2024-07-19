// LeetCode Easy 112 (Amazon Maybe)

package Trees;

public class HasPathSum {
    public boolean hasPathSum(Node root, int targetSum) {
        if(root == null) {
            return false;
        }

        if(root.left == null && root.right == null && targetSum == root.val) {
            return true;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
