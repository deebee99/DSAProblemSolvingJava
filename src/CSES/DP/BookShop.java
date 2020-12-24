package CSES.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class BookShop {
    static int n, m;
    static int[] price;
    static int[] pages;

    static int[][] dp;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dp = new int[n + 1][m + 1];
        price = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        pages = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(calcII());
    }

    /**
     * Recursive solution gave TLE
     * @param index
     * @param cost
     * @return
     */
    private static int calc(int index, int cost) {
        if (index == n || cost > m) {
            return 0;
        }
        String s = index + "," + cost;
        if (dp[index][cost] != 0) return dp[index][cost];
        int ans = 0;
        if (cost + price[index] <= m) {
            ans = pages[index] + calc(index + 1, cost + price[index]);
        }
        ans = Math.max(ans, calc(index + 1, cost));

        return dp[index][cost] = ans;
    }

    /**
     * bottom up dp
     * @return
     */
    private static int calcII() {
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (price[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], pages[i - 1] + dp[i - 1][j - price[i - 1]]);
                }
                else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][m];
    }
}
