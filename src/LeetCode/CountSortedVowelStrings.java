package LeetCode;

public class CountSortedVowelStrings {
    /**
     * Recursive Solution without dp followed by dp solution.
     *
     * @param n
     * @return
     */
    private int dp[][] = new int[5][50];

    public int countVowelStringsDP(int n) {
        int withoutDpAns = countVowelStringsHelper(0, 0, n);
        return countVowelStringsHelperDP(0, 0, n);
    }

    private int countVowelStringsHelper(int vowelIndex, int index, int n) {
        if (index == n) return 1;
        if (vowelIndex == 5) return 0;
        int ans = countVowelStringsHelper(vowelIndex, index + 1, n);

        for (int i = vowelIndex + 1; i < 5; i++) {
            ans += countVowelStringsHelper(i, index + 1, n);
        }
        return ans;
    }

    private int countVowelStringsHelperDP(int vowelIndex, int index, int n) {
        if (index == n) return 1;
        if (vowelIndex == 5) return 0;
        if (dp[vowelIndex][index] != 0) return dp[vowelIndex][index];
        int ans = countVowelStringsHelperDP(vowelIndex, index + 1, n);

        for (int i = vowelIndex + 1; i < 5; i++) {
            ans += countVowelStringsHelperDP(i, index + 1, n);
        }
        return dp[vowelIndex][index] = ans;
    }

}