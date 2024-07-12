package Trees;

public class Node {
    int val;
    Node left;
    Node right;
    Node next;

    Node(){}

    Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
