
import java.util.*;

public class SerializeAndDeserializeBST {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "";
            StringBuilder sb = new StringBuilder();
            preorder(root, sb);
            return sb.toString().trim();
        }

        private void preorder(TreeNode root, StringBuilder sb) {
            if (root == null) return;
            sb.append(root.val + " ");
            preorder(root.left, sb);
            preorder(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.isEmpty()) return null;
            String[] preorder = data.split(" ");
            return helper(preorder, 0, preorder.length - 1);
        }

        public TreeNode helper(String[] preorder, int start, int end) {
            if (start > end) return null;
            TreeNode root = new TreeNode(Integer.parseInt(preorder[start]));
            int index;
            for (index = start; index <= end; index++) {
                if (Integer.parseInt(preorder[index]) > Integer.parseInt(preorder[start]))
                    break;
            }

            root.left = helper(preorder, start + 1, index - 1);
            root.right = helper(preorder, index, end);

            return root;
        }
    }

}
