package LeetCode;

import LeetCode.LargestRectangleInHistogram;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        if (rows == 0) return 0;

        int[][] dp = new int[rows + 1][cols + 1];
        int maxsqlen = 0;
        for (int i = 0; i < cols; i++) dp[0][i] = matrix[0][i] == '1' ? 1 : 0;

        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = dp[i - 1][j] + 1;
                }
            }
        }
        for (int i = 0; i < rows; i++)
            maxsqlen = Math.max(maxsqlen, LargestRectangleInHistogram.largestRectangleArea(dp[i]));

        return maxsqlen;
    }
}
