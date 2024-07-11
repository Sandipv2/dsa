/*
* Asked in GOOGLE
*/
package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class NextSuccessor {
    public static void main(String[] args) {
        TreeImpApna.BinaryTree tree = new TreeImpApna.BinaryTree();
        int[] nodes = {1,2,3,4,-1,-1,5,-1,-1,6,-1,-1,7,8,9,-1,-1,10,-1,-1,-1};
        Node root = tree.buildTree(nodes);

        Node next = successor(root, 6);

        if(next != null) {
            System.out.println(next.val);
        } else {
            System.out.println("No Successor");
        }
    }

    static Node successor(Node root, int key) {
        if(root == null) return null;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            Node currentNode = q.remove();
            if(currentNode.left != null) {
                q.add(currentNode.left);
            }
            if(currentNode.right != null) {
                q.add(currentNode.right);
            }

            if(currentNode.val == key) {
                break;
            }
        }

        return q.peek();
    }
}
