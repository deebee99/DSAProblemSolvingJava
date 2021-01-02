package LeetCode;

public class FindAllGoodStrings {
    private int mod = 1000000007;
    int[][][][] dp;
    int[] lps;
    char[] evil;
    int n;
    char[] s1;
    char[] s2;

    public int findGoodStrings(int len, String s1, String s2, String evil) {
        this.evil = evil.toCharArray();
        lps = computeLPS(this.evil);
        n = len;
        this.s1 = s1.toCharArray();
        this.s2 = s2.toCharArray();
        dp = new int[501][51][2][2];

        int ans = dfs(0, 0, true, true);

        return ans;

    }

    int dfs(int i, int evilMatchIndex, boolean leftFlag, boolean rightFlag) {

        if (evilMatchIndex == evil.length) return 0;
        if (i == n) return 1;
        if (dp[i][evilMatchIndex][leftFlag ? 1 : 0][rightFlag ? 1 : 0] != 0)
            return dp[i][evilMatchIndex][leftFlag ? 1 : 0][rightFlag ? 1 : 0];

        char to = rightFlag ? s2[i] : 'z';
        char from = leftFlag ? s1[i] : 'a';
        long res = 0;

        for (char c = from; c <= to; c++) {
            int j = evilMatchIndex;
            while (j > 0 && evil[j] != c) j = lps[j - 1];
            if (c == evil[j]) j++;
            res += dfs(i + 1, j, leftFlag && (c == from), rightFlag && (c == to));

        }
        res %= mod;
        return dp[i][evilMatchIndex][leftFlag ? 1 : 0][rightFlag ? 1 : 0] = (int) res;
    }

    int[] computeLPS(char[] temp) {

        int n = temp.length;
        int[] lps = new int[n];
        lps[0] = 0;
        int len = 0;

        int i = 1;
        while (i < n) {
            if (temp[i] == temp[len]) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        System.out.println(new FindAllGoodStrings().findGoodStrings(8, "leetcode", "leetgoes", "leet"));
    }
}
