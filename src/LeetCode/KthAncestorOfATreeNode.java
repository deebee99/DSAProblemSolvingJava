package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KthAncestorOfATreeNode {
    /**
     * TLE Solution
     */
    class TreeAncestor {
        int[] parent;
        Map<Integer, List<Integer>> ancestorMap = new HashMap<>();

        public TreeAncestor(int n, int[] p) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = p[i];
            ancestorMap.put(0, new ArrayList<>());
            ancestorMap.get(0).add(-1);
        }

        public int getKthAncestor(int node, int k) {

            if (ancestorMap.containsKey(node) && ancestorMap.get(node).size() >= k)
                return ancestorMap.get(node).get(k - 1);
            if (!ancestorMap.containsKey(node) || ancestorMap.get(node).size() < k) {
                int ancestor;
                if (!ancestorMap.containsKey(node)) {
                    ancestor = parent[node];
                    ancestorMap.put(node, new ArrayList<>());
                } else {
                    int temp = ancestorMap.get(node).get(ancestorMap.get(node).size() - 1);
                    if (temp == -1) return -1;
                    ancestor = parent[temp];
                    k = k - ancestorMap.get(node).size();
                }
                while (ancestor != -1 && k > 0) {
                    ancestorMap.get(node).add(ancestor);
                    ancestor = parent[ancestor];
                    k--;
                }
                return ancestor;
            }
            return -1;
        }
    }

    /**
     * Binary Uplifting Solution (followed Lee215's Solution)
     */
    class TreeAncestor2 {
        int[][] jump;
        int maxPow;

        public TreeAncestor2(int n, int[] parent) {
            maxPow = (int) (Math.log(n) / Math.log(2)) + 1;
            jump = new int[maxPow][n];
            jump[0] = parent;
            for (int p = 1; p < maxPow; p++) {
                for (int j = 0; j < n; j++) {
                    int pre = jump[p - 1][j];
                    jump[p][j] = pre == -1 ? -1 : jump[p - 1][pre];
                }
            }
        }

        public int getKthAncestor(int node, int k) {
            int maxPow = this.maxPow;
            while (k > 0 && node > -1) {
                if (k >= 1 << maxPow) {
                    node = jump[maxPow][node];
                    k -= 1 << maxPow;
                } else
                    maxPow -= 1;
            }
            return node;
        }
    }

}
