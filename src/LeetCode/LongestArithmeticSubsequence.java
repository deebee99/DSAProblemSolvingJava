package LeetCode;

public class LongestArithmeticSubsequence {
    public int longestArithSeqLength(int[] arr) {
        int n = arr.length, ans = 0;
        int[][] dp = new int[n + 2][1600];
        for (int i = 0; i < n + 2; i++) dp[i] = new int[1600];

        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int diff = arr[i] - arr[j];
                dp[i][1000 + diff] = Math.max(dp[i][1000 + diff], dp[j][diff + 1000] + 1);
                ans = Math.max(dp[i][1000 + diff], ans);
            }
        }
        return ans + 1;
    }
}
