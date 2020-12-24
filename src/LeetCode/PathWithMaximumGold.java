package LeetCode;

public class PathWithMaximumGold {
    class Solution {
        private int n, m, ans = 0;
        private int dirs[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        public int getMaximumGold(int[][] grid) {
            n = grid.length;
            m = grid[0].length;

            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    if (grid[i][j] != 0) dfs(i, j, grid, 0);

            return ans;
        }

        private void dfs(int i, int j, int grid[][], int value) {
            ans = Math.max(ans, value);

            if (i >= n || j >= m || i < 0 || j < 0 || grid[i][j] == 0) return;

            int temp = grid[i][j];
            grid[i][j] = 0;
            for (int dir[] : dirs) {
                dfs(i + dir[0], j + dir[1], grid, value + temp);
            }
            grid[i][j] = temp;
        }
    }
}