// LeetCode Hard 297 (Googel, Facebook, Amazon)

package Trees;

public class SerializeDeserializeBT {
//    Serialization is the process of converting a data structure or object into a sequence of bits so that it can be
//    stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in
//    the same or another computer environment.

    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    void serializeHelper(Node root, StringBuilder sb) {
        if(root == null) {
            sb.append("n,");
            return;
        }

        sb.append(root.val).append(",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    public Node deserialize(String data) {
        String[] nodes = data.split(",");
        return deserializeHelper(nodes);
    }

    int idx = -1;
    Node deserializeHelper(String[] nodes) {
        idx++;
        if(nodes[idx].equals("n")) {
            return null;
        }

        int val = Integer.parseInt(nodes[idx]);
        Node root = new Node(val);

        root.left = deserializeHelper(nodes);
        root.right = deserializeHelper(nodes);

        return root;
    }
}
