package LeetCode;

public class FriendsCircle {
    public int findCircleNum(int[][] mat) {
        int n = mat.length, components = 0;
        if (n == 0) return 0;
        boolean visited[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, mat);
                components++;
            }
        }
        return components;
    }

    private void dfs(int index, boolean visited[], int[][] mat) {
        visited[index] = true;
        for (int j = 0; j < mat.length; j++) {
            if (mat[index][j] == 1 && !visited[j])
                dfs(j, visited, mat);
        }
    }
}