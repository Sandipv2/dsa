// LeetCode Medium 199

package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTRightView {
    public List<Integer> rightSideView(Node root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(q.size() > 0) {
            int n = q.size();
            for(int i = 0; i < n; i++) {
                Node current = q.remove();

                if(i == n - 1) result.add(current.val);

                if(current.left != null) {
                    q.add(current.left);
                }
                if(current.right != null) {
                    q.add(current.right);
                }
            }

        }

        return result;
    }
}
