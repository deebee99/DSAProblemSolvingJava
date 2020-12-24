package LeetCode;

import java.util.Arrays;

public class CheckIfAStringCanBreakAnotherString {
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);

        boolean result = check(c1, c2);
        if (!result) result = check(c2, c1);
        return result;
    }

    boolean check(char[] c1, char[] c2) {
        int n = c1.length;
        for (int i = 0; i < n; i++) {
            if (c1[i] > c2[i]) return false;
        }
        return true;
    }
}
