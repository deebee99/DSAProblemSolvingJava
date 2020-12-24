package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lcaUsingBinaryUplifting {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode u, TreeNode v) {
        int levelU=calcLevel(root,u,0);
        int levelV=calcLevel(root,v,0);
        int height=calcHeight(root,0);
        if(levelV<levelU) return lowestCommonAncestor(root,v,u);
        int diff=levelV-levelU;
        int nodes=traverse(root);
        int ip[][]=new int[height][nodes];
        Map<TreeNode,List<TreeNode>> adj=new HashMap<>();
        //  preprocessAdj(root,adj);
return null;
    }

    private void preprocessAdj(TreeNode root, Map<TreeNode, List<Integer>> adj) {
        adj.put(root,new ArrayList<>());
        if(root.left!=null) adj.get(root).add(0);
    }

    private int traverse(TreeNode root) {
        if(root==null) return 0;
        return 1+traverse(root.left)+traverse(root.right);
    }

    private int calcHeight(TreeNode root,int height) {
        if(root==null) return height;
        int leftHeight=calcHeight(root.left,height+1);
        int rightHeight=calcHeight(root.right,height+1);
        return Math.max(leftHeight,rightHeight);
    }

    private int calcLevel(TreeNode root, TreeNode u,int level) {
        if(root==null) return 0;
        if(root==u) return level;

        int left=calcLevel(root.left,u,level+1);
        return left!=0 ? left : calcLevel(root.right,u,level+1);
    }
}
