package CSES.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RemovingDigits {
    private static int[] dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        dp = new int[n + 1];
        System.out.println(calculate(n));

    }

    private static int calculate(int n) {
       //System.out.println(n);
        if (n < 10) return 1;
        if (dp[n] != 0) return dp[n];
        int temp = n;
        int ans = Integer.MAX_VALUE;
        int rem = Integer.MIN_VALUE;
        while (temp > 0) {
            rem = Math.max(temp % 10, rem);
            temp = temp / 10;
        }
        ans = Math.min(ans, 1 + calculate(n - rem));
        return dp[n] = ans;
    }
}
