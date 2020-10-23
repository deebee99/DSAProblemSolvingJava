package LeetCode;

public class MaximalSquare {
    public int maximalSquare(char[][] mat) {
        int n = mat.length;
        if (n == 0) return 0;
        int m = mat[0].length;
        if (n == 1 && m == 1) return mat[0][0] == '0' ? 0 : 1;

        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            matrix[i] = new int[m];
            for (int j = 0; j < m; j++)
                matrix[i][j] = mat[i][j] == '1' ? 1 : 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1)
                    matrix[i][j] += matrix[i - 1][j];
            }
        }
        int ans = 0;

        for (int i = 0; i < m; i++)
            if (matrix[0][i] == 1)
                ans = 1;


        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] >= 1) {
                    for (int k = matrix[i][j]; k >= 1; k--) {
                        int count = 0;
                        for (int x = j; x < m && x < j + k; x++) {
                            if (matrix[i][x] >= k) count++;
                            else break;
                        }
                        if (count == k) {
                            ans = Math.max(count * count, ans);
                            break;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
