package CSES.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TwoSetsII {

    static int n, max;
    static int mod = 1000000007;
    static long[][] dp;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            n = Integer.parseInt(br.readLine());
            max = (n * (n + 1)) / 2;

            if (max % 2 == 0) {
                max /= 2;
                dp = new long[n + 1][max + 1];
                for (long[] arr : dp) {
                    Arrays.fill(arr, -1);
                }
                System.out.println((calculate(1, 0)));
            } else {
                System.out.println(0);
            }

    }

    private static long calculate(int index, int sum) {

        if (sum == max) return 1;
        if (index > n - 1 || sum > max) return 0;
        if (dp[index][sum] != -1) return dp[index][sum];
        long ans = 0;
        ans = calculate(index + 1, sum) + calculate(index + 1, sum + index);

        return dp[index][sum] = ans % mod;
    }
}
