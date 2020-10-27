package LeetCode;

/**
 * O(N^2) DP Solution
 */
public class PalindromicSubstrings {
    private boolean isPali[][];

    public int countSubstrings(String s) {
        if (s.isEmpty()) return 0;
        int n = s.length(), count = s.length();

        isPali = new boolean[n][n];
        for (int i = 0; i < n; i++) isPali[i][i] = true;

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                final boolean isEqual = s.charAt(i) == s.charAt(i + len - 1);
                if (len == 2) {
                    if (isEqual) isPali[i][i + 1] = true;
                } else {
                    if (isEqual && isPali[i + 1][i + len - 2])
                        isPali[i][i + len - 1] = true;
                }
                if (isPali[i][i + len - 1]) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * O(N) Solution using Manacher's Algorithm
     */
    public int countSubstringsWithManacherAlgorithm(String s) {
        int n=s.length(),count=0;;

        int d1[]=new int[n],d2[]=new int[n];

        for (int i = 0, l = 0, r = -1; i < n; i++) {
            int k = (i > r) ? 1 : Math.min(d1[l + r - i], r - i + 1);
            while (0 <= i - k && i + k < n && s.charAt(i - k) == s.charAt(i + k)) {
                k++;
            }
            d1[i] = k--;
            if (i + k > r) {
                l = i - k;
                r = i + k;
            }
            count+=d1[i];
        }

        for (int i = 0, l = 0, r = -1; i < n; i++) {
            int k = (i > r) ? 0 : Math.min(d2[l + r - i + 1], r - i + 1);
            while (0 <= i - k - 1 && i + k < n && s.charAt(i - k - 1) == s.charAt(i + k)) {
                k++;
            }
            d2[i] = k--;
            if (i + k > r) {
                l = i - k - 1;
                r = i + k ;
            }
            count+=d2[i];
        }
        return count;

    }

}
