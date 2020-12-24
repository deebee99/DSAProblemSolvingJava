package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class NumberOfOperationsToMakeNetworkConnected {
    boolean[] visited;
    List<Integer>[] adj;

    int components = 0;
    int edges = 0;
    int size = 0;

    public int makeConnected(int n, int[][] connections) {
        adj = new List[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();

        }
        for (int[] edge : connections) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        int redundantEdges = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                edges = edges / 2;
                if (edges > size - 1)
                    redundantEdges += edges - (size - 1);

                components++;
                size = 0;
                edges = 0;
            }
        }
        return redundantEdges >= (components - 1) ? components - 1 : -1;
    }

    private void dfs(int i) {
        size++;
        visited[i] = true;

        for (int v : adj[i]) {
            edges++;
            if (!visited[v]) {
                dfs(v);
            }
        }
    }
}
