package LeetCode;

import java.util.Arrays;

public class MatrixBlockSum {
    /**
     * O(M*N*M*N) Time complexity
     * @param mat
     * @param K
     * @return
     */
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int n = mat.length;
        if (n == 0) return new int[][]{};
        int m = mat[0].length;
        int answers[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int r = Math.max(0, i - K); r <= Math.min(n - 1, i + K); r++)
                    for (int c = Math.max(0, j - K); c <= Math.min(m - 1, j + K); c++)
                        answers[i][j] += mat[r][c];
            }
        }
        return answers;
    }

    /**
     * DP Implementation
     */
    public int[][] matrixBlockSum2(int[][] mat, int K) {
            int m = mat.length, n = mat[0].length;
            int[][] rangeSum = new int[m + 1][n + 1];
            for (int i = 0; i < m; ++i)
                for (int j = 0; j < n; ++j)
                    rangeSum[i + 1][j + 1] = rangeSum[i + 1][j] + rangeSum[i][j + 1] - rangeSum[i][j] + mat[i][j];
            int[][] ans = new int[m][n];
            for (int i = 0; i < m; ++i)
                for (int j = 0; j < n; ++j) {
                    int r1 = Math.max(0, i - K), c1 = Math.max(0, j - K), r2 = Math.min(m, i + K + 1), c2 = Math.min(n, j + K + 1);
                    ans[i][j] = rangeSum[r2][c2] - rangeSum[r2][c1] - rangeSum[r1][c2] + rangeSum[r1][c1];
                }
            return ans;

    }
}
