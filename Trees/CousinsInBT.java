// Leetcode Easy 993. Cousins in Binary Tree

package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class CousinsInBT {
    public boolean isCousins(Node root, int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(q.size() > 0) {
            int n = q.size();
            boolean foundX = false;
            boolean foundY = false;

            for(int i = 0; i < n; i++) {
                Node node = q.remove();

                if(node.left != null && node.right != null) {
                    if(node.left.val == x && node.right.val == y || (node.left.val == y && node.right.val == x)) {
                        return false;
                    }
                }

                if(node.val == x) foundX = true;
                if(node.val == y) foundY = true;

                if(node.left != null) {
                    q.add(node.left);
                }
                if(node.right != null) {
                    q.add(node.right);
                }
            }

            if(foundX && foundY) return true;
        }

        return false;
    }
}
