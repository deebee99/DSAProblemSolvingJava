import java.util.Arrays;

public class OnesAndZeroes {
    private int[][] count;
    private int length;
    private int dp[][][];

    public int findMaxForm(String[] strs, int m, int n) {
        length = strs.length;
        if (length == 0) return 0;
        count = new int[length + 1][2];
        dp = new int[length + 1][m + 1][n + 1];
        for (int i = 0; i <= length; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = new int[n + 1];
            }
        }
        dp = new int[length + 1][m + 1][n + 1];
        for (int i = 0; i <= length; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++)
                    dp[i][j][k] = -1;
            }
        }
        int i = 0;
        for (String s : strs) {
            count[i] = new int[2];
            int ones = 0, zeroes = 0;
            for (char ch : s.toCharArray()) {
                if (ch == '1') ones++;
                else zeroes++;
            }
            count[i][0] = zeroes;
            count[i++][1] = ones;
        }
        return findMaxFormHelper(strs, 0, m, n);

    }

    private int findMaxFormHelper(String[] strs, int i, int m, int n) {
        if (i == length) return 0;

        int temp = 0;
        if (dp[i][m][n] != -1) return dp[i][m][n];
        if (count[i][0] <= m && count[i][1] <= n)
            temp = 1 + findMaxFormHelper(strs, i + 1, m - count[i][0], n - count[i][1]);
        temp = Math.max(temp, findMaxFormHelper(strs, i + 1, m, n));
        dp[i][m][n] = temp;

        return temp;
    }

    public static void main(String[] args) {
        String[] strs = {"111001", "1", "0", "10", "0001"};
        System.out.println(new OnesAndZeroes().findMaxForm(strs, 4, 3));
    }
}
