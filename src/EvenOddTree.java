import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class EvenOddTree {
    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0, prev = Integer.MIN_VALUE;
        queue.add(null);

        while (queue.size() > 1) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                queue.add(null);
                level++;
                if (level % 2 == 0) prev = Integer.MIN_VALUE;
                else prev = Integer.MAX_VALUE;
                continue;
            }
            if (level % 2 == 0) {
                if (cur.val % 2 != 1 || cur.val <= prev) return false;
            } else {
                if (cur.val % 2 != 0 || cur.val >= prev) return false;
            }
            prev = cur.val;
            if (cur.left != null) queue.add(cur.left);
            if (cur.right != null) queue.add(cur.right);

        }
        return true;
    }
}
