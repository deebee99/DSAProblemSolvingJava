package LeetCode;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MinCostToConnectAllPoints {
    class Point {
        int x;
        int y;
        int rank;
        Point parent;
        List<Pair<Point, Double>> adj;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.rank = 0;
            this.parent = this;
            adj = new ArrayList<>();
        }

        public void add(Point p, double d) {
            adj.add(new Pair<Point, Double>(p, d));
        }
    }

    class Edge {
        Point p1;
        Point p2;
        Double dist;

        public Edge(Point p1, Point p2, Double dist) {
            this.p1 = p1;
            this.p2 = p2;
            this.dist = dist;
        }
    }

    public int minCostConnectPoints(int[][] p) {
        int n = p.length;
        Point[] points = new Point[n];
        int index = 0;
        PriorityQueue<Edge> edges = new PriorityQueue<Edge>((e1, e2) -> {
            if (e1.dist <= e2.dist) return -1;
            return 1;
        });

        for (int[] point : p) points[index++] = new Point(point[0], point[1]);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double dist = Math.abs(points[i].x - points[j].x) + Math.abs(points[i].y - points[j].y);
                edges.add(new Edge(points[i], points[j], dist));
            }
        }

        return kruskalAlgo(points, edges);
    }

    public int kruskalAlgo(Point[] points, PriorityQueue<Edge> edges) {
        int cost = 0;
        int n = points.length;
        int edgeCount = 0;
        while (!edges.isEmpty() && edgeCount < n - 1) {
            Edge edge = edges.poll();
            if (!Union(edge.p1, edge.p2)) {
                cost += edge.dist;
                edgeCount++;
            }
        }
        return cost;
    }

    public Point find(Point p) {
        if (p.parent != p) p.parent = find(p.parent);
        return p.parent;
    }

    public boolean Union(Point p1, Point p2) {
        Point parent1 = find(p1);
        Point parent2 = find(p2);
        if (parent1.equals(parent2)) return true;

        if (parent1.rank < parent2.rank) parent1.parent = parent2;
        else parent2.parent = parent1;
        return false;
    }
}