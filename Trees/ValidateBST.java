// LeetCode Medium 98 (Amazon, Google)

package Trees;

public class ValidateBST {
    public boolean isValidBST(Node root) {
        return validate(root, null, null);
    }

    boolean validate(Node root, Integer min, Integer max) {
        if(root == null) return true;

        if(min != null && root.val <= min || (max != null && root.val >= max)) {
            return false;
        }

        return validate(root.left, min, root.val) && validate(root.right, root.val, max);
    }
}
