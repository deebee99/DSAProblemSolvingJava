package LeetCode;

public class LongestHappyPrefix {
    public String longestPrefix(String s) {
        int maxLength = kmpConstructTable(s);
        return maxLength == 0 ? "" : s.substring(0, maxLength);
    }

    private int kmpConstructTable(String s) {
        char[] temp = s.toCharArray();
        int n = s.length();
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
        return lps[n - 1];
    }
}
