package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class Traversals {
    static void preorderTraversal(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.val+" ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    static void inorderTraversal(Node root) {
        if(root == null) {
            return;
        }

        inorderTraversal(root.left);
        System.out.print(root.val+" ");
        inorderTraversal(root.right);
    }

    public static void postorderTraversal(Node root) {
        if(root == null) {
            return;
        }

        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.val + " ");
    }

    public static void levelTraversal(Node root) {
        if(root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()) {
            Node currNode = q.remove();

            if (currNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            }
            else {
                System.out.print(currNode.val+" ");
                if(currNode.left != null) {
                    q.add(currNode.left);
                }
                if(currNode.right!= null) {
                    q.add(currNode.right);
                }
            }
        }
    }

    static int count(Node root) {
        if(root == null) {
            return 0;
        }

        return 1 + count(root.left) + count(root.right);
    }

    static int sum(Node root) {
        if(root == null) {
            return 0;
        }

        int leftSum = sum(root.left);
        int rightSum = sum(root.right);

        return root.val + leftSum + rightSum;
    }

    static int height(Node root) {
        if(root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int height = Math.max(leftHeight, rightHeight) + 1;

        return height;
    }

    static void prettyPrint(Node root) {
        prettyHelper(root, 0);
    }

    private static void prettyHelper(Node root, int level) {
        if(root == null) return;

        prettyHelper(root.right, level + 1);

        if(level != 0) {
            for(int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|----->"+root.val);
        }
        else {
            System.out.println(root.val);
        }
        prettyHelper(root.left, level + 1);
    }

    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        TreeImpApna.BinaryTree tree = new TreeImpApna.BinaryTree();
        //Node root = tree.buildTree(nodes);

        //preorderTraversal(root);
        //inorderTraversal(root);
        //postorderTraversal(root);
        //levelTraversal(root);

        //System.out.println(count(root));
        //System.out.println(sum(root));
        //System.out.println(height(root));
        BinaryTree mytree = new BinaryTree();

        mytree.populate();
        mytree.levelTravel();
        System.out.println("Sum "+mytree.sum);
        System.out.println("Total Node "+mytree.totalNodes);
    }
}
