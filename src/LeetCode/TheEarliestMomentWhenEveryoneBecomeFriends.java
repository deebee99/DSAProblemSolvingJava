package LeetCode;

import java.util.PriorityQueue;

public class TheEarliestMomentWhenEveryoneBecomeFriends {
    private int[] parent;
    private int[] rank;

    class Edge {
        int p1;
        int p2;
        int dist;

        public Edge(int p1, int p2, int dist) {
            this.p1 = p1;
            this.p2 = p2;
            this.dist = dist;
        }
    }

    public int earliestAcq(int[][] logs, int n) {
        PriorityQueue<Edge> edges = new PriorityQueue<Edge>((e1, e2) -> {
            return e1.dist - e2.dist;
        });
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            rank[i] = 0;
            parent[i] = i;
        }
        for (int arr[] : logs) edges.add(new Edge(arr[1], arr[2], arr[0]));

        return kruskalAlgo(edges, n);
    }

    public int kruskalAlgo(PriorityQueue<Edge> edges, int n) {
        int cost = Integer.MIN_VALUE;
        int edgeCount = 0;
        while (!edges.isEmpty() && edgeCount < n - 1) {
            Edge edge = edges.poll();
            if (!Union(edge.p1, edge.p2)) {
                cost = Math.max(cost, edge.dist);
                edgeCount++;
            }
        }
        if (edgeCount < n - 1) return -1;
        return cost;
    }

    public int find(int p) {
        if (parent[p] != p) parent[p] = find(parent[p]);
        return parent[p];
    }

    public boolean Union(int p1, int p2) {
        int parent1 = find(p1);
        int parent2 = find(p2);
        if (parent1 == parent2) return true;

        if (rank[parent1] < rank[parent2]) parent[parent1] = parent2;
        else parent[parent2] = parent1;
        return false;
    }
}
