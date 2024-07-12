// Leetcode Easy 101

package Trees;

public class SymmetricBT {
    public boolean isSymmetric(Node root) {
        return helper(root.left, root.right);
    }

    public boolean helper(Node left, Node right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;

        return left.val == right.val && helper(left.left, right.right) && helper(left.right, right.left);
    }
}
