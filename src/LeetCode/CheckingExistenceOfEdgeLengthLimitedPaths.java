package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class CheckingExistenceOfEdgeLengthLimitedPaths {
    Map<Integer, Integer>[] dist;
    Map<Integer, Integer>[] adj;

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        adj = new Map[n];
        dist = new Map[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new HashMap<>();
            dist[i] = new HashMap<>();
        }
        for (int[] edge : edgeList) {
            adj[edge[0]].put(edge[1], Math.min(adj[edge[0]].getOrDefault(edge[1], Integer.MAX_VALUE), edge[2]));
            adj[edge[1]].put(edge[0], Math.min(adj[edge[1]].getOrDefault(edge[0], Integer.MAX_VALUE), edge[2]));
        }
        for (int i = 0; i < n; i++) {
            for (int j : adj[i].keySet()) {
                dfs(i, j, adj[i].get(j));
            }
        }
        boolean[] ans = new boolean[queries.length];
        int index = 0;
        for (int[] query : queries) {
            int i = query[0];
            int j = query[1];
            if (dist[i].containsKey(j) && dist[i].get(j) < query[2]) {
                ans[index] = true;
            }
            index++;
        }
        return ans;
    }

    private void dfs(int i, int j, int distance) {
        dist[i].put(j, Math.min(distance, dist[i].getOrDefault(j, Integer.MAX_VALUE)));
        for (int v : adj[j].keySet()) {
            dfs(i, v, Math.max(distance, adj[j].get(v)));
        }
    }
}
