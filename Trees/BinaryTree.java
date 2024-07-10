package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {
    private Node root = new Node();
    Scanner scan = new Scanner(System.in);

    int sum = 0;
    int totalNodes = 0;

    void populate() {
        System.out.println("Enter root : ");
        root.val = scan.nextInt();
        sum += root.val;
        totalNodes++;
        populate(root);
    }

    private void populate(Node node) {
        if (node == null) {
            return;
        }

        // Credit : ChatGPT
        System.out.println("Enter left and right of " + node.val + " (enter 'false' for no node):");
        String leftVal = scan.next();
        String rightVal = scan.next();

        if (!leftVal.equals("false")) {
            node.left = new Node(Integer.parseInt(leftVal));
            sum += node.left.val;
            totalNodes++;
            populate(node.left);
        }

        if (!rightVal.equals("false")) {
            node.right = new Node(Integer.parseInt(rightVal));
            sum += node.right.val;
            totalNodes++;
            populate(node.right);
        }
    }

    void levelTravel() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int n = q.size();

            for(int i = 0; i < n; i++) {
                Node temp = q.remove();
                System.out.print(temp.val);

                if(temp.left != null) {
                    q.add(temp.left);
                }

                if(temp.right != null) {
                    q.add(temp.right);
                }
            }
            System.out.println();
        }
    }

}
