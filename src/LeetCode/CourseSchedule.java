package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> adjacencyList[] = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) adjacencyList[i] = new ArrayList<>();
        int indegree[] = new int[numCourses];
        for (int edge[] : prerequisites) {
            adjacencyList[edge[1]].add(edge[0]);
            indegree[edge[0]]++;
        }
        if (isCyclic(adjacencyList, numCourses)) return false;
        int visited[] = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0 && visited[i] == 0)
                dfs(i, adjacencyList, visited);
        }
        for (int i : visited)
            if (i == 0) return false;

        return true;
    }

    private void dfs(int i, List<Integer>[] adjacencyList, int[] visited) {
        if (visited[i] == 1) return;
        visited[i] = 1;
        for (int v : adjacencyList[i])
            if (visited[v] == 0) dfs(v, adjacencyList, visited);
    }

    /**
     * Cycle detection in directed graph
     * ref : https://www.geeksforgeeks.org/detect-cycle-in-a-graph/
     *
     * @param adjacencyList
     * @param V
     * @return
     */
    private boolean isCyclic(List<Integer>[] adjacencyList, int V) {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++)
            if (isCyclicUtil(i, visited, recStack, adjacencyList))
                return true;

        return false;
    }

    private boolean isCyclicUtil(int i, boolean[] visited,
                                 boolean[] recStack, List<Integer>[] adjacencyList) {
        if (recStack[i]) return true;
        if (visited[i]) return false;

        visited[i] = true;
        recStack[i] = true;
        List<Integer> children = adjacencyList[i];

        for (Integer c : children)
            if (isCyclicUtil(c, visited, recStack, adjacencyList))
                return true;

        recStack[i] = false;

        return false;
    }


    /**
     * Much shorter code using Topological sort concept
     * ref : lee215 's solution
     */
    public boolean canFinishTopoSort(int n, int[][] prerequisites) {
        ArrayList<Integer>[] G = new ArrayList[n];
        int[] degree = new int[n];
        ArrayList<Integer> bfs = new ArrayList();
        for (int i = 0; i < n; ++i) G[i] = new ArrayList<Integer>();
        for (int[] e : prerequisites) {
            G[e[1]].add(e[0]);
            degree[e[0]]++;
        }
        for (int i = 0; i < n; ++i) if (degree[i] == 0) bfs.add(i);
        for (int i = 0; i < bfs.size(); ++i)
            for (int j : G[bfs.get(i)])
                if (--degree[j] == 0) bfs.add(j);
        return bfs.size() == n;
    }
}