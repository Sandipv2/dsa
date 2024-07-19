// LeetCode Medium 105 (Amazon)

package Trees;

import java.util.HashMap;
import java.util.Map;

public class BuildBTFromPreInOrder {
    public Node buildTree(int[] preorder, int[] inorder) {
        int m = preorder.length;
        int n = inorder.length;
        Map<Integer, Integer> inMap = new HashMap<>();

        for(int i = 0; i < n; i++) {
            inMap.put(inorder[i], i);
        }

        return build(preorder, 0, m-1, inorder, 0, n-1, inMap);
    }

    Node build(int[] preorder, int preStart, int preEnd,int[] inorder, int inStart, int inEnd, Map<Integer, Integer> mp) {
        if(preStart > preEnd || inStart > inEnd) {
            return null;
        }

        Node root = new Node(preorder[preStart]);
        int idx = mp.get(root.val);
        int inRemain = idx - inStart;

        root.left = build(preorder, preStart + 1, preStart + inRemain, inorder, inStart, idx - 1, mp);
        root.right = build(preorder, preStart + inRemain + 1, preEnd ,inorder, idx + 1, inEnd, mp);

        return root;
    }
}
