package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class findBridgesInAnUndirectedGraph {
    boolean[] visited;
    List<Integer>[] adj;
    int[] low;
    int[] dist;
    int[] parent;
    int time = 0;
    int bridges = 0;
    int components = 0;

    public int creatGraph(int n, int[][] connections) {
        adj = new List[n];
        visited = new boolean[n];
        low = new int[n];
        dist = new int[n];
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            parent[i] = -1;
        }
        for (int[] edge : connections) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                findBridges(i);
                components++;

            }
        }
        return bridges;
    }

    private void findBridges(int i) {

        visited[i] = true;
        low[i] = time;
        dist[i] = time;
        time++;

        for (int v : adj[i]) {
            if (!visited[v]) {
                parent[v] = i;
                findBridges(v);
                low[i] = Math.min(low[i], low[v]);
                if (low[v] > dist[i]) {
                    bridges++;
                }
            } else if (v != parent[i]) {
                low[i] = Math.min(low[i], dist[v]);
            }
        }
    }
}
