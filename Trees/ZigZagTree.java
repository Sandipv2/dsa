// LeetCode Medium 103

package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTree {
    public List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        Queue<Node> q = new LinkedList<>();

        q.add(root);
        boolean leftToRight = true;

        while (q.size() > 0) {
            int n = q.size();
            List<Integer> level = new ArrayList<>(n);

            for (int i = 0; i < n; i++) {
                Node currentNode = q.remove();

                if (leftToRight) {
                    level.add(currentNode.val);
                } else {
                    level.add(0, currentNode.val);
                }

                if (currentNode.left != null) {
                    q.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    q.add(currentNode.right);
                }
            }

            leftToRight = !leftToRight;
            result.add(level);
        }

        return result;
    }
}
