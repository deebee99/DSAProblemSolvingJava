package CSES.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RectangularCutting {
    private static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        String st = br.readLine();

        int a = Integer.parseInt(st.split(" ")[0]);
        int b = Integer.parseInt(st.split(" ")[1]);
        int max = Math.max(a, b);
        dp = new int[max + 1][max + 1];
        System.out.println(calculate(a, b));

    }

    private static int calculate(int a, int b) {
        if (a== 0 || b == 0 || a == b) {
            return 0;
        }
       if (dp[a][b] != 0) return dp[a][b];
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        int ans = 250000;
        for (int i = 1; i < max; i++) {
            int breadth1 = Math.min(min, i);
            int length1 = Math.max(min, i);
            int breadth2 = Math.min(max - i, min);
            int length2 = Math.max(max - i, min);
            ans = Math.min(ans, 1 + calculate(breadth1, length1) + calculate(breadth2, length2));
        }
        for (int i = 1; i < min; i++) {
            int breadth1 = Math.min(max, i);
            int length1 = Math.max(max, i);
            int breadth2 = Math.min(min - i, max);
            int length2 = Math.max(min - i, max);
            ans = Math.min(ans, 1 + calculate(breadth1, length1) + calculate(breadth2, length2));
        }
        return dp[a][b] = ans;
    }

}
