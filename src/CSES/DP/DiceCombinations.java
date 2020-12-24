package CSES.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DiceCombinations {
    static long mod = 1000000007;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        if (n <=5)
        System.out.println(calculate(0, 0, n));
        else
            System.out.println(calculate2(n));
    }

    /**
     * Recursive solution MLE
     * @param dice
     * @param sum
     * @param n
     * @return
     */
    private static long calculate(int dice, int sum, int n) {
        if (sum == n) {
            return 1;
        }
        if (sum > n) return 0;
        long ans = 0;

        for (int i = 1; i <= 6; i++) {
            if (i > (n - sum)) break;
            ans = (ans % mod + calculate(dice + 1, sum + i, n) % mod) % mod;
        }
        return  ans;
    }

    private  static  long calculate2(int n) {
      long[] dp = new long[n + 1];
      dp[0] = 1;
      dp[1] = 1;
      dp[2] = 2;
      dp[3] = 4;
      dp[4] = 8;
      dp[5] = 16;

      for (int i = 6; i <=n; i++) {
          for (int j = 1; j <= 6; j++) {
              dp[i] = (dp[i] % mod + dp[i - j] % mod) % mod;
          }
      }
      return dp[n];
    }
}
