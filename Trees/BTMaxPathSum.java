// LeetCode Hard 124

package Trees;

public class BTMaxPathSum {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(Node root) {
        solve(root);
        return max;
    }

    int solve(Node root) {
        if(root == null) {
            return 0;
        }

        int left = solve(root.left);
        int right = solve(root.right);

        left = Math.max(left, 0);
        right = Math.max(right, 0);

        int sum = left + right + root.val;
        max = Math.max(max, sum);

        return Math.max(left, right) + root.val;
    }
}
