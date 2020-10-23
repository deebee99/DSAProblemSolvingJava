package LeetCode;

import java.util.Arrays;


public class RussianDollEnvelopes {
    private static int compareHeightAndWidth(int[] env1, int[] env2) {
        if (env1[0] < env2[0]) return -1;
        else if (env1[0] > env2[0]) return 1;
        else {
            if (env1[1] < env2[1]) return -1;
            else if (env1[1] > env2[1]) return 1;
        }
        return 1;
    }

    public int maxEnvelopes(int[][] envelopes) {
        //static function to compare
        Arrays.sort(envelopes, RussianDollEnvelopes::compareHeightAndWidth);
        //lambda version to compare
        Arrays.sort(envelopes, (env1, env2) -> {
            if (env1[0] < env2[0]) return -1;
            else if (env1[0] > env2[0]) return 1;
            else {
                if (env1[1] < env2[1]) return -1;
                else if (env1[1] > env2[1]) return 1;
            }
            return 1;
        });

        int n = envelopes.length, ans = 0;
        if (n <= 1) return n;
        int[] overlap = new int[n];
        Arrays.fill(overlap, 1);

        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1])
                    overlap[i] = Math.max(overlap[i], overlap[j] + 1);
            }
            ans = Math.max(ans, overlap[i]);
        }
        return ans;
    }
}

