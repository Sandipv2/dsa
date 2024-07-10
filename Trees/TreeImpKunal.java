package Trees;

import java.util.Scanner;

public class TreeImpKunal {
    Node root = new Node();

    void populate(Scanner scan) {
        System.out.println("Enter root : ");
        int val = scan.nextInt();
        root.val = val;
        populate(scan, root);
    }

    void populate(Scanner scan, Node node) {
        System.out.println("Want to enter val left for "+node.val);
        boolean left = scan.nextBoolean();
        if(left) {
            System.out.println("Enter the left val for "+node.val);
            int val = scan.nextInt();
            node.left = new Node(val);
            populate(scan, node.left);
        }

        System.out.println("Want to enter val right for "+node.val);
        boolean right = scan.nextBoolean();
        if(right) {
            System.out.println("Enter the right val for "+node.val);
            int val = scan.nextInt();
            node.right = new Node(val);
            populate(scan, node.right);
        }
    }

}
