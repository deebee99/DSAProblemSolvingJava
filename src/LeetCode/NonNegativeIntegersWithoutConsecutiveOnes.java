package LeetCode;

public class NonNegativeIntegersWithoutConsecutiveOnes {
    int[][][] dp = new int[33][2][2];

    public int findIntegers(int num) {

        String binary = Integer.toBinaryString(num);
        return helper(0, 0, binary, 1);
    }

    private int helper(int index, int prev, String binary, int flag) {
        if (index == binary.length()) return 1;
        if (dp[index][prev][flag] != 0) return dp[index][prev][flag];
        int ans = 0;
        int limit = 1;
        if (flag == 1) limit = binary.charAt(index) - '0';

        for (int i = 0; i <= limit; i++) {
            if (prev == 1 && i == 1) continue;
            if (flag == 1 && i == limit) ans += helper(index + 1, i, binary, 1);
            else ans += helper(index + 1, i, binary, 0);
        }


        return dp[index][prev][flag] = ans;
    }
}
