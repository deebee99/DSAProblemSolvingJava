package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Digit DP Solution (TLE since 1<=n<=10^9)
 */
public class NumbersAtMostNGivenDigitSet {
    private ArrayList<Integer> nums = new ArrayList<>();
    private ArrayList<Integer> intDigits = new ArrayList<>();
    private Map<String, Integer> map = new HashMap<>();

    public int atMostNGivenDigitSet(String[] digits, int n) {

        intDigits.add(0);
        for (String s : digits) intDigits.add(Integer.parseInt(s));
        //    Collections.sort(intDigits);
        while (n > 0) {
            nums.add(n % 10);
            n = n / 10;
        }

        Collections.reverse(nums);
        return atMostNGivenDigitSetHelper(0, 0, 1) - 1;
    }

    private int atMostNGivenDigitSetHelper(int n, int index, int flag) {
        if (index >= nums.size()) {
            return 1;
        }
        String s = n + " " + index + " " + flag;

        if (map.containsKey(s)) return map.get(s);
        int limit = intDigits.get(intDigits.size() - 1), ans = 0;
        if (flag == 1) limit = nums.get(index);
        for (int i : intDigits) {
            if (i == 0 && n > 0) continue;
            if (i > limit) break;
            int newFlag = flag;
            if (newFlag == 1 && i < limit) newFlag = 0;
            ans += atMostNGivenDigitSetHelper(n * 10 + i, index + 1, newFlag);
        }
        map.put(s, ans);
        return ans;
    }

    /**
     * Mathematical approach coupled with dp
     */
    public int atMostNGivenDigitSet2(String[] D, int N) {
        String S = String.valueOf(N);
        int K = S.length();
        int[] dp = new int[K+1];
        dp[K] = 1;

        for (int i = K-1; i >= 0; --i) {
            // compute dp[i]
            int Si = S.charAt(i) - '0';
            for (String d: D) {
                if (Integer.parseInt(d) < Si)
                    dp[i] += Math.pow(D.length, K-i-1);
                else if (Integer.parseInt(d) == Si)
                    dp[i] += dp[i+1];
            }
        }

        for (int i = 1; i < K; ++i)
            dp[0] += Math.pow(D.length, i);
        return dp[0];
    }
}
