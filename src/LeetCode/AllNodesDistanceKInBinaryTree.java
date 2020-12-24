package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class AllNodesDistanceKInBinaryTree {
    private List<Integer> ans = new ArrayList<>();
    private int found = 0;
    private TreeNode targetNode = null;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        findChildrenAtKDistance(target, k);
        List<TreeNode> ancestors = new ArrayList<>();
        findAncestors(ancestors, root, target);
        targetNode = target;
        for (int i = ancestors.size() - 1; i >= 0; i--) {
            k--;
            distanceK(root, ancestors.get(i), k);
            if (k == 0) break;
        }

        return ans;
    }

    private void findAncestors(List<TreeNode> ancestors, TreeNode root, TreeNode target) {
        if (root == null) return;
        if (root == target) {
            found = 1;
            return;
        }
        if (found == 1) return;
        ancestors.add(root);
        findAncestors(ancestors, root.left, target);
        if (found == 1) return;
        findAncestors(ancestors, root.right, target);
        if (found == 0) ancestors.remove(ancestors.size() - 1);
    }

    private void findChildrenAtKDistance(TreeNode root, int k) {
        if (root == null) return;
        if (targetNode != null && root == targetNode) return;
        if (k == 0) {
            ans.add(root.val);
            return;
        }
        findChildrenAtKDistance(root.left, k - 1);
        findChildrenAtKDistance(root.right, k - 1);
    }
}