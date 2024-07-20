// LeetCode Medium 129

//    1
//  /   \
//  2   3
//
//  12 + 13 = 25

package Trees;

public class SumRootToLeafNumbers {
    public int sumNumbers(Node root) {
        return solve(root, 0);
    }

    int solve(Node root, int sum) {
        if(root == null) return 0;

        sum = (sum * 10) + root.val;

        if(root.left == null && root.right == null) {
            return sum;
        }

        int left = solve(root.left, sum);
        int right = solve(root.right, sum);

        return left + right;
    }
}
