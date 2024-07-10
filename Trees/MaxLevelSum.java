package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSum {
    static int MaxLevel(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int max = Integer.MIN_VALUE;
        int level = 1;
        int maxiLevel = -1;

        while(!q.isEmpty()) {
            int levelSum = 0;
            int n = q.size();

            for(int i = 0; i < n; i++) {
                Node temp = q.remove();
                levelSum += temp.val;

                if(temp.left != null) {
                    q.add(temp.left);
                }
                if(temp.right != null) {
                    q.add(temp.right);
                }
            }


            if(levelSum > max) {
                max = levelSum;
                maxiLevel = level;
            }

            level++;
        }

        return maxiLevel;
    }
}
