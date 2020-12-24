package LeetCode;

public class MaximumDifferenceBetweenNodeAndAncestor {

    private int res = Integer.MIN_VALUE;

    public int maxAncestorDiff(TreeNode root) {
        helperFindMin(root);
        helperFindMax(root);
        return res;
    }

    private int helperFindMin(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;
        if (root.left == null && root.right == null) return root.val;
        int left = helperFindMin(root.left);
        int right = helperFindMin(root.right);

        int min = Math.min(left, right);
        left = left == Integer.MAX_VALUE ? Integer.MIN_VALUE : Math.abs(left - root.val);
        right = right == Integer.MAX_VALUE ? Integer.MIN_VALUE : Math.abs(right - root.val);

        res = Math.max(res, Math.max(left, right));
        return Math.min(root.val, min);
    }

    private int helperFindMax(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        if (root.left == null && root.right == null) return root.val;
        int left = helperFindMax(root.left);
        int right = helperFindMax(root.right);

        int min = Math.max(left, right);
        left = left == Integer.MIN_VALUE ? Integer.MIN_VALUE : Math.abs(left - root.val);
        right = right == Integer.MIN_VALUE ? Integer.MIN_VALUE : Math.abs(right - root.val);

        res = Math.max(res, Math.max(left, right));
        return Math.max(root.val, min);
    }
}