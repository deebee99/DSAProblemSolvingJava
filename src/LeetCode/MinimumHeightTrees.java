package LeetCode;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumHeightTrees {

        class TreeNode{
            public int val;
            public List<TreeNode> children;
            public TreeNode(int val){
                this.val=val;
                children=new ArrayList<>();
            }
        }
        List<Integer> ans=new ArrayList<>();
        private Map<TreeNode,Integer> heightMap=new HashMap<>();
        private Map<Integer,TreeNode> nodeMap=new HashMap<>();
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            for(int i=0;i<n;i++) nodeMap.put(i,new TreeNode(i));

            for(int edge[] : edges){
                nodeMap.get(edge[0]).children.add(nodeMap.get(edge[1]));
                nodeMap.get(edge[1]).children.add(nodeMap.get(edge[0]));
            }
            int minHeight=Integer.MAX_VALUE;
            for(int i=0;i<n;i++){
                int value=calculateHeight(nodeMap.get(i),null,new HashMap<TreeNode,Integer>());
                heightMap.put(nodeMap.get(i),value);
                minHeight=Math.min(minHeight,value);
            }

            for(Map.Entry<TreeNode,Integer> entry : heightMap.entrySet()){
                if(entry.getValue()==minHeight) ans.add(entry.getKey().val);
            }
            return ans;
        }

        private int calculateHeight(TreeNode treeNode,TreeNode root,Map<TreeNode,Integer> map) {
            int height=0;

            if(map.containsKey(treeNode)) return map.get(treeNode);
            for(TreeNode child : treeNode.children){
                if(child!=root)
                    height=Math.max(calculateHeight(child,treeNode,map)+1,height);
            }
            map.put(treeNode,height);
            return height;
        }

}
