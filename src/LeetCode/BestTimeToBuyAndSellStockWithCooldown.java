package LeetCode;

public class BestTimeToBuyAndSellStockWithCooldown {

    /**
     * O (N^2 Complexity)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length, maxProfit = 0;
        if (n <= 1) return 0;

        int dp[] = new int[n];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1];
            for (int j = i - 1; j >= 0; j--) {
                if (prices[j] < prices[i]) {
                    int temp = j - 2 >= 0 ? dp[j - 2] : 0;
                    dp[i] = Math.max(dp[i], temp + prices[i] - prices[j]);
                }
            }
            maxProfit = Math.max(maxProfit, dp[i]);
        }

        return maxProfit;
    }

    /**
     * O(N) Complexity
     * Ref : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75931/Easiest-JAVA-solution-with-explanations
     */

    public int maxProfit2(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;

        int b0 = -prices[0], b1 = b0;
        int s0 = 0, s1 = 0, s2 = 0;

        for(int i = 1; i < prices.length; i++) {
            b0 = Math.max(b1, s2 - prices[i]);
            s0 = Math.max(s1, b1 + prices[i]);
            b1 = b0; s2 = s1; s1 = s0;
        }
        return s0;
    }
}
