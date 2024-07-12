/* LeetCode Medium 116
*  Asked in Amazon London SDE Role 2022
*/

package Trees;

/*
   class Node {
      int val;
      Node left;
      Node right;
      Node next;
    }
*/
public class PopulateNextPointer {
    public Node connect(Node root) {
        if (root == null) return root;
        Node node = root;

        // Space Optimised : O(1)
        while (node.left != null) {
            Node current = node;

            while (current != null) {
                current.left.next = current.right;

                if (current.next != null) {
                    current.right.next = current.next.left;
                }
                current = current.next;
            }

            node = node.left;
        }

        return root;
    }
}
