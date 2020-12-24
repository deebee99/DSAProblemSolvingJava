package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class CorrectABinaryTree {
    private Map<TreeNode, TreeNode> parent;

    private void traverse(TreeNode node, TreeNode p) {
        if (node == null) return;

        if (parent.containsKey(node)) {
            TreeNode parentOfParent = parent.get(p);
            if (parentOfParent.left != null && parentOfParent.left.equals(p)) parentOfParent.left = null;
            else parentOfParent.right = null;
            return;
        }
        parent.put(node, p);
        traverse(node.right, node);
        traverse(node.left, node);
    }

    public TreeNode correctBinaryTree(TreeNode root) {
        parent = new HashMap<>();
        traverse(root, null);
        return root;
    }
}
