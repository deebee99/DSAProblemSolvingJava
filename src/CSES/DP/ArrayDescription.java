package CSES.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class ArrayDescription {
    static int n, m;
    static int[] arr;
    static int mod = 1000000007;


    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(calc());
    }

    private static long calc() {
        long[][] dp = new long[n + 1][m + 1];
        dp[0][0] = 0;
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1) {
                    if (arr[i - 1] == 0 || arr[i - 1] == j) {
                        dp[i][j] = 1;
                    }
                } else if (arr[i - 1] == 0 || arr[i - 1] == j) {
                    dp[i][j] += dp[i - 1][j];
                    if (j > 1) dp[i][j] += dp[i - 1][j - 1];
                    if (j < m) dp[i][j] += dp[i - 1][j + 1];
                    dp[i][j] %= mod;
                }
            }
        }
        for (long i : dp[n]) {
            ans += i;
        }
        return ans % mod;
    }
}
