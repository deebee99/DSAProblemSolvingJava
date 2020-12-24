package CSES.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MoneySums {

    static int n, m;
    static int[] arr;
    static int mod = 1000000007;
    static List<Integer> list = new ArrayList<>();
    static boolean[][] dp;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        dp = new boolean[n + 1][n * 1000 + 1];
        calculate();
        System.out.println(list.size());
        for (int i : list) {
            if (i == 0) continue;
            System.out.print(i + " ");
        }
    }

    private static void calculate() {
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = dp[i - 1][j];
                int left = j - arr[i - 1];
                if (left >= 0 && dp[i - 1][left]) {
                    dp[i][j] = true;
                }
            }
        }
        for (int j = 1; j < dp[0].length; j++) {
            if (dp[n][j]) {
                list.add(j);
            }
        }
    }
}