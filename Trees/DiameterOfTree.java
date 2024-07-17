// LeetCode Easy 543 (Google, Amazon, Facebook)

package Trees;

public class DiameterOfTree {
    public int diameterOfBinaryTree(Node root) {
        int[] diameter = {0};
        helper(root, diameter);

        return diameter[0];
    }

    int helper(Node root, int[] diameter) {
        if(root == null) return 0;

        int left = helper(root.left, diameter);
        int right = helper(root.right, diameter);

        diameter[0] = Math.max(diameter[0], left + right);

        return Math.max(left, right) + 1;
    }
}
