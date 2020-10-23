package LeetCode;

public class UniquePathsIII {
    private int paths = 0;
    private int sx, sy, dx, dy, n, m;

    public int uniquePathsIII(int[][] grid) {
        int positiveGrids = 0;
        n = grid.length;
        if (n == 0) return 0;
        m = grid[0].length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                if (grid[i][j] >= 0) positiveGrids++;
                if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                } else if (grid[i][j] == 2) {
                    dx = i;
                    dy = j;
                }
            }
        return search(grid, sx, sy, positiveGrids);
    }

    private int search(int grid[][], int sx, int sy, int gridsRemaining) {
        if (sx < 0 || sy < 0 || sx >= n || sy >= m || grid[sx][sy] == -1) return 0;
        if (sx == dx && sy == dy && gridsRemaining == 1) return 1;
        if (gridsRemaining <= 0) return 0;
        grid[sx][sy] = -1;
        int ans = search(grid, sx, sy + 1, gridsRemaining - 1) + search(grid, sx, sy - 1, gridsRemaining - 1) + search(grid, sx - 1, sy, gridsRemaining - 1) + search(grid, sx + 1, sy, gridsRemaining - 1);
        grid[sx][sy] = 0;
        return ans;
    }
}
