// LeetCode Medium 230 (Amazon, Google)

package Trees;

public class KthMinimumBST {
    public int kthSmallest(Node root, int k) {
        int[] ans = {0,0};

        find(root, k, ans);

        return ans[1];
    }

    void find(Node root, int k, int[] ans) {
        if(root == null) return;

        find(root.left, k, ans);

        ans[0]++;
        if(ans[0] == k) {
            ans[1] = root.val;
            return;
        }

        find(root.right, k, ans);
    }
}
