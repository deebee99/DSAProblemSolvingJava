package LeetCode;

import java.util.Arrays;

public class ReducingDishes {
    private int dp[][];

    /**
     * DP Solution  
     * @param satisfaction
     * @return
     */
    public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length;
        dp = new int[n + 1][n + 1];
        Arrays.sort(satisfaction);
        return maxSatisfactionHelper(0, 1, n, satisfaction);
    }

    private int maxSatisfactionHelper(int index, int day, int n, int[] satisfaction) {
        if (index == n) return 0;
        if (dp[index][day] != 0) return dp[index][day];
        if (satisfaction[index] < 0)
            return dp[index][day] = Math.max((satisfaction[index] * day) + maxSatisfactionHelper(index + 1, day + 1, n, satisfaction), maxSatisfactionHelper(index + 1, day, n, satisfaction));
        else
            return dp[index][day] = (satisfaction[index] * day) + maxSatisfactionHelper(index + 1, day + 1, n, satisfaction);
    }
}
