package Trees;

/*
* AVL - Self Balancing Binary Tree
* Adelson-Velsky and Landis tree
*/
public class AVL {
    static public class Node {
        int val;
        Node left, right;
        int height;

        Node(int val) {
            this.val = val;
        }
    }

    static public int height(Node node) {
        if(node == null) {
            return -1;
        }

        return node.height;
    }

    static public Node insert(Node root, int val) {
        if(root == null) {
            return new Node(val);
        }

        if(val < root.val) {
            root.left = insert(root.left, val);
        }
        else {
            root.right = insert(root.right, val);
        }

        root.height = Math.max(height(root.left), height(root.right)) + 1;
        return rotate(root);
    }

    static public Node rotate(Node root) {
        if(height(root.left) - height(root.right) > 1) {
            // left
            if(height(root.left.left) - height(root.left.right) > 0) {
                // left left case
                return rightRotate(root);
            }
            if(height(root.left.left) - height(root.left.right) < 0) {
                // left right case
                root.left = leftRotate(root.left);
                return rightRotate(root);
            }
        }
        if(height(root.left) - height(root.right) < -1) {
            // right
            if(height(root.right.left) - height(root.right.right) < 0) {
                // right right case
                return leftRotate(root);
            }
            if(height(root.right.left) - height(root.right.right) > 0) {
                //  right left case
                root.right = rightRotate(root.right);
                return leftRotate(root);
            }
        }

        return root;
    }

    static public Node rightRotate(Node p) {
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        c.height = Math.max(height(c.left), height(c.right)) + 1;
        p.height = Math.max(height(p.left), height(p.right)) + 1;

        return c;
    }

    static public Node leftRotate(Node c) {
        Node p = c.right;
        Node t = p.left;

        p.left = c;
        c.right = t;

        c.height = Math.max(height(c.left), height(c.right)) + 1;
        p.height = Math.max(height(p.left), height(p.right)) + 1;

        return p;
    }

    static void print(Node root) {
        print(root, 1);
    }

    static private void print(Node root, int level) {
        if(root == null) return;

        print(root.right, level+1);
        if(level != 1) {
            for (int i = 1; i < level-1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|----->"+root.val);
        }
        else {
            System.out.println(root.val);
        }
        print(root.left, level+1);
    }

    static Node delete(Node root, int val) {
        if(val < root.val) {
            root.left = delete(root.left, val);
        }
        if(val > root.val) {
            root.right = delete(root.right, val);
        }
        else {
            // case 1 : Has No child
            if(root.left == null && root.right == null) {
                return null;
            }

            // case 2 : Has one child
            if(root.left == null) {
                return root.right;
            }
            if(root.right == null) {
                return root.left;
            }

            // case 3 : Has two children
            Node successorNode = successorFinder(root.right);
            root.val = successorNode.val;
            root.right = delete(root.right, successorNode.val);
            //return root;
            root.height = Math.max(height(root.left), height(root.right)) + 1;
        }
        return rotate(root);
    }

    static Node successorFinder(Node node) {
        while(node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        int[] nodes = {1,2,3,4,5,6};
        Node root = null;
        for(int n : nodes) {
            root = insert(root, n);
        }

        print(root);
        System.out.println();
        System.out.println();
        System.out.println();
        delete(root, 2);
        print(root);
    }
}
