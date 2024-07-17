// LeetCode Medium 114 (Facebook)

package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class FlattenBT {

    public void flatten(Node root) { // No Extra Space used
        if (root == null)
            return;

        Node current = root;

        while (current != null) {
            if (current.left != null) {
                Node rightMost = current.left;

                while (rightMost.right != null) {
                    rightMost = rightMost.right;
                }

                rightMost.right = current.right;
                current.right = current.left;
                current.left = null;
            }

            current = current.right;
        }
    }

//    public void flatten(Node root) { // Using extra space, the queue
//        if(root == null) return;
//
//        Queue<Node> q = new LinkedList<>();
//
//        preorder(root, q);
//
//        Node temp = q.remove(); // Removed the root
//        while(q.size() > 0) {
//            Node next = q.remove();
//
//            temp.right = next;
//            temp.left = null;
//            temp = next;
//        }
//    }

    void preorder(Node root, Queue<Node> q) {
        if(root == null) return;

        q.add(root);
        preorder(root.left, q);
        preorder(root.right, q);
    }
}
