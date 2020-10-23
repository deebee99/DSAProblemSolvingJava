package LeetCode;

import LeetCode.TreeNode;

public class DeleteNodeInBST {
    TreeNode predecessor=null;
    TreeNode last=null;
    TreeNode mainRoot=null;
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        TreeNode node=findNode(root,key);
        mainRoot=root;
        root=deleteNodeHelper(root,node);
        return root;
    }

    private TreeNode deleteNodeHelper(TreeNode root, TreeNode node) {
        if(root==null) return null;
        if (root==node) {
            if(node.left==null && node.right==null) {
                node = null;
                return node;
            }
            else if(node.left==null || node.right==null){
                node=(node.left!=null) ? node.left : node.right;
                return node;
            }
            else {
                findPredecessor(root,node);
                root.val=predecessor.val;
                return deleteNodeHelper(root,predecessor);
            }
        }
        else {
            root.left=deleteNodeHelper(root.left,node);
            root.right=deleteNodeHelper(root.right,node);
            return root;
        }

    }

    private void findPredecessor(TreeNode root, TreeNode node) {
        if(root==null) return;
        findPredecessor(root.left,node);
        if(root==node) {
            predecessor=last;
            return;
        }
        last=root;
        findPredecessor(root.right,node);
    }

    private TreeNode findNode(TreeNode root, int key) {
        if(root==null) return null;
        if(root.val==key) return root;
        TreeNode left=findNode(root.left,key);
        TreeNode right=findNode(root.right,key);
        return (left==null ? right : left);
    }
}
