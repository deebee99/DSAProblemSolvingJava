package CSES.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class CoinCombinationsI {
    static int[] coins;
    static int x;
    static int n;
    static int mod = 1000000007;
    static long[] dp;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        String st = (br.readLine());

        n = Integer.parseInt(st.split(" ")[0]);
        x = Integer.parseInt(st.split(" ")[1]);
        dp = new long[x + 1];
        Arrays.fill(dp, 0);
        coins = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // Arrays.sort(coins);
        System.out.println(calc(x));
    }

    private static long calc(int x) {
        dp[0] = 1;
        for (int i = 1; i <= x; i++) {
            for (int j : coins) {
                if (j > i) continue;
                dp[i] = (dp[i] + dp[i - j]);
            }
            dp[i] %= mod;
        }
        return dp[x];
    }
}
