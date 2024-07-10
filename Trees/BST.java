package Trees;

import java.util.ArrayList;
import java.util.List;

public class BST {
    static Node buildBST(Node root, int val) {
        if(root == null) {
            root = new Node(val);
            return root;
        }

        if(val < root.val) {
            root.left = buildBST(root.left, val);
        }
        else {
            root.right = buildBST(root.right, val);
        }

        return root;
    }

    static boolean search(Node root, int val) {
        if(root == null) return false;

        if(root.val == val) return true;

        if(val < root.val) {
            return search(root.left, val);
        }
        else {
            return search(root.right, val);
        }
    }

    static Node delete(Node root, int val) {
        if(val < root.val) {
            root.left = delete(root.left, val);
        }

        else if(val > root.val) {
            root.right = delete(root.right, val);
        }

        else {
            // Case 1 : No children
            if(root.left == null && root.right == null) {
                return null;
            }

            // Case 2 : Has one child
            if(root.left == null) {
                return root.right;
            }
            if(root.right == null) {
                return root.left;
            }

            // Case 3 : Has two children

            Node successorNode = inorderSuccessor(root.right);
            root.val = successorNode.val;
            root.right = delete(root.right, successorNode.val);

//            This too can be done. Logic - Coder Army;
//            int n = rightMinElement(root.right);
//            root.right = delete(root.right, n);
//            Node newNode = new Node(n);
//            newNode.left = root.left;
//            newNode.right = root.right;
//            return newNode;
        }

        return root;
    }

//    static int rightMinElement(Node node) {
//        while(node.left != null) {
//            node = node.left;
//        }
//        return node.val;
//    }

    static Node inorderSuccessor(Node root) {
        while(root.left != null) {
            root = root.left;
        }

        return root;
    }

    static void prettyPrint(Node root, int level) {
        if(root == null) return;

        prettyPrint(root.right, level + 1);

        if(level != 0) {
            for(int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|----->"+root.val);
        }
        else {
            System.out.println(root.val);
        }

        prettyPrint(root.left, level + 1);
    }

    static void rangeSearch(Node root, int a, int b) {
        if(root == null) return;

        if(root.val >= a && root.val <= b) {
            rangeSearch(root.left, a, b);
            System.out.print(root.val+" ");
            rangeSearch(root.right, a, b);
        }
        else if (a > root.val) {
            rangeSearch(root.right, a, b);
        }
        else {
            rangeSearch(root.left, a, b);
        }
    }

    static void rootToLeaf(Node root, List<Integer> path) {
        if(root == null) return;

        path.add(root.val);

        if(root.left == null && root.right == null) {
            System.out.println(path);
        }

        rootToLeaf(root.left, path);
        rootToLeaf(root.right, path);

        path.remove (path.size() - 1);

    }

    static boolean isBalanced(Node root) {
        return balancedHeight(root) != -1;
    }

    private static int balancedHeight(Node root) {
        if(root == null) {
            return 0;
        }

        int lh = balancedHeight(root.left);
        if(lh == -1) return -1;
        int rh = balancedHeight(root.right);
        if(rh == -1) return -1;

        if(Math.abs(lh - rh) > 1) return -1;

        return Math.max(lh, rh) + 1;
    }

    public static void main(String[] args) {
        int[] nodes = {30,20,10,22,21,25,40,32,50};
        Node root = null;

        for(int n : nodes) {
            root = buildBST(root, n);
        }


        prettyPrint(root, 0);
        delete(root, 20);
        System.out.println();
        System.out.println("-------------");
        System.out.println();
        prettyPrint(root, 0);
    }
}
