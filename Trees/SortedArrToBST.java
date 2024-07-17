// LeetCode Easy 108 (Facebook)

package Trees;

public class SortedArrToBST {
    public Node sortedArrayToBST(int[] nums) {
        int n = nums.length;
        return buildTree(0, n-1, nums);
    }

    Node buildTree(int s, int e, int[] nums) {
        if(s > e) return null;

        int mid = s + (e- s) / 2;

        Node root = new Node(nums[mid]);

        root.left = buildTree(s, mid-1, nums);
        root.right = buildTree(mid+1, e, nums);

        return root;
    }
}
