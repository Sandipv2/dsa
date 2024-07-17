// LeetCode Medium 236 (Amazon)

package Trees;

public class LowerCommonAncestor {
    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        return helper(root, p, q);
    }

    public Node helper(Node root, Node p, Node q) {
        if(root == null) return null;

        if(root == p || root == q) return root;

        Node left = helper(root.left, p, q);
        Node right = helper(root.right, p, q);

        if(left != null && right != null) return root;

        if(left != null) return left;

        return right;
    }
}
