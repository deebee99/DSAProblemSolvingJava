package CSES.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class CoinCombinationsII {
    static int[] coins;
    static int x;
    static int n;
    static int mod = 1000000007;
    static int[] dp;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        String st = (br.readLine());

        n = Integer.parseInt(st.split(" ")[0]);
        x = Integer.parseInt(st.split(" ")[1]);
        dp = new int[x + 1];

        coins = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(calc());
    }

    private static long calc() {
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= x; j++) {
                if (j == 0) {
                    dp[j] = 1;
                    continue;
                }
                if (coins[i - 1] <= j) {
                    dp[j] = (dp[j] + dp[j - coins[i - 1]]) % mod;
                }

            }
        }
        return dp[x] % mod;
    }
}
