package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class KthLevelSum {
    static int KthSum(Node root, int k) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int level = 1;
        int sum = 0;

        while (!q.isEmpty()) {
            if(level == k) {
                int n = q.size();
                for(int i =0; i < n; i++) {
                    sum += q.remove().val;
                }
                break;
            }

            int n = q.size();
            for (int i = 0; i < n; i++) {
                Node temp = q.remove();
                if(temp.left != null) {
                    q.add(temp.left);
                }
                if(temp.right != null) {
                    q.add(temp.right);
                }
            }

            level++;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, 7,-1,-1,8, -1, -1};

        TreeImpApna.BinaryTree tree = new TreeImpApna.BinaryTree();

        Node root = tree.buildTree(nodes);
        Traversals.levelTraversal(root);
        System.out.println();
        System.out.println(MaxLevelSum.MaxLevel(root));
    }
}
