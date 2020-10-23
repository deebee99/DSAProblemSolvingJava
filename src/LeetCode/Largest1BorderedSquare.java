package LeetCode;

import javafx.util.Pair;

import java.util.Arrays;

public class Largest1BorderedSquare {
    private Pair[][] dp;
    int flag = 0;

    public int largest1BorderedSquare(int[][] grid) {
        int n = grid.length;
        int m=grid[0].length;
        dp = new Pair[n][];
        for (int i = 0; i < n; i++) {
            Pair[] temp = new Pair[m];
            dp[i] = temp;
            Arrays.fill(dp[i], new Pair<>(0, 0));
        }
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (grid[0][i] == 1) {
                    flag = 1;
                    dp[0][i] = new Pair<>(1, 1);
                    dp[i][0] = new Pair<>(1, 1);
                }
                continue;
            }
            if (grid[i][0] == 1) {
                flag = 1;
                int colCount = (int) dp[i - 1][0].getValue();
                dp[i][0] = new Pair<>(1, colCount + 1);
            }
        }
        for (int i = 1; i < m; i++) {

            if (grid[0][i] == 1) {
                flag = 1;
                int rowCount = (int) dp[0][i - 1].getKey();
                dp[0][i] = new Pair<>(rowCount + 1, 1);
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (grid[i][j] == 1) {
                    flag = 1;
                    int rowCount = (int) dp[i][j - 1].getKey();
                    int colCount = (int) dp[i - 1][j].getValue();
                    dp[i][j] = new Pair<>(rowCount + 1, colCount + 1);
                }
            }
        }
        if (flag == 0) return 0;
        int ans = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int rowCount = (int) dp[i][j].getKey(), colCount = (int) dp[i][j].getValue();
                int count=Math.min(rowCount,colCount);
                if (count!=0) {
                    int lowerRow = i - count + 1;
                    int lowerCol = j - count + 1;
                    if (lowerCol >= 0 && lowerRow >= 0) {
                        if (count <= (int) dp[lowerRow][j].getKey() && count <= (int) dp[i][lowerCol].getValue()) {
                            ans = Math.max(ans, count+1);
                        }
                    }
                }
            }

        }
        return ans*ans;
    }
}
