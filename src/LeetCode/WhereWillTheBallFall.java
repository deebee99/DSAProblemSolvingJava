package LeetCode;

public class WhereWillTheBallFall {
    final int up = 0;
    final int left = 2;
    final int right = 3;

    public int[] findBall(int[][] grid) {
        int n = grid.length;
        if (n == 0) return new int[0];
        int m = grid[0].length;
        int[] ans = new int[m];
        for (int col = 0; col < m; col++) {
            ans[col] = dfs(0,col,n,m,grid, up);
        }
        return ans;
    }

    private int dfs(int row, int col, int n, int m, int[][] grid, int dir) {
        if (row == n) return 1;
        if (row < 0 || row >= n || col < 0 || col >= m) return -1;
        int ans;
        if (grid[row][col] == 1) {
            if (dir == up) ans = dfs(row,col + 1,n, m, grid,left);
            else if (dir == left) ans = dfs(row + 1, col, n, m, grid, up);
            else return -1;
        }
        else {
            if (dir == up) ans = dfs(row,col - 1,n, m, grid,right);
            else if (dir == right) ans = dfs(row + 1, col, n, m, grid, up);
            else return -1;
        }
        return ans;
    }
}
