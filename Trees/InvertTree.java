// LeetCode Easy 226 (Google)

package Trees;

public class InvertTree {
    public Node invert(Node root) {
        if(root == null) return null;

        Node left = invert(root.left);
        Node right = invert(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}
