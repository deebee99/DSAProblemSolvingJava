package LeetCode;

public class RecoverBinarySearchTree {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;

    /**
     * Using O(N) extra space (in recursion stack)
     *
     * @param root
     */
    public void recoverTree(TreeNode root) {
        morrisInorderTraversal(root);

        final int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void traverse(TreeNode root) {

        if (root == null) return;
        traverse(root.left);
        if (prev != null) {
            if (first == null && prev.val >= root.val) first = prev;
            if (first != null && prev.val >= root.val) second = root;
        }
        prev = root;
        traverse(root.right);
    }

    /**
     * Using Morris traversal
     */
    private void morrisInorderTraversal(TreeNode cur) {
        while (cur != null) {
            if (cur.left == null) {
                cur = getSwappedTreeNode(cur);
            } else {
                TreeNode inorderPredecessor = cur.left;
                while (inorderPredecessor.right != null && inorderPredecessor.right != cur)
                    inorderPredecessor = inorderPredecessor.right;
                if (inorderPredecessor.right == null) {
                    inorderPredecessor.right = cur;
                    cur = cur.left;
                } else {
                    inorderPredecessor.right = null;
                    cur = getSwappedTreeNode(cur);
                }
            }
        }
    }

    private TreeNode getSwappedTreeNode(TreeNode cur) {
        if (prev != null) {
            if (first == null && prev.val >= cur.val) first = prev;
            if (first != null && prev.val >= cur.val) second = cur;
        }
        prev = cur;
        cur = cur.right;
        return cur;
    }
}