package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class IncreasingOrderSearchTree {
    private void inorder(TreeNode root, List<TreeNode> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
    }

    public TreeNode increasingBST(TreeNode root) {
        List<TreeNode> inorderList = new ArrayList<>();
        inorder(root, inorderList);
        TreeNode prev = null, head = null;
        for (TreeNode node : inorderList) {
            node.left = null;
            if (prev != null) prev.right = node;
            else head = node;
            prev = node;
        }
        return head;
    }
}