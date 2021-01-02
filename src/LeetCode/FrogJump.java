package LeetCode;

public class FrogJump {
    int[][] dp;

    public boolean canCross(int[] stones) {
        if (stones.length <= 1) return true;
        if (stones[1] - stones[0] != 1) return false;
        int n = stones.length;
        dp = new int[n + 1][n + 1];
        return jump(0, 1, stones);
    }

    private boolean jump(int index, int steps, int[] stones) {
        if (index == stones.length - 1) return true;
        if (dp[index][steps] != 0) {
            return dp[index][steps] == 1;
        }
        boolean ans = false;
        for (int i = index + 1; i < stones.length; i++) {
            int gap = stones[i] - stones[index];
            if (gap <= (steps + 1) && gap >= (steps - 1)) {
                if (jump(i, gap, stones)) {
                    ans = true;
                    break;
                }
            }
        }
        dp[index][steps] = ans ? 1 : -1;
        return ans;
    }
}
