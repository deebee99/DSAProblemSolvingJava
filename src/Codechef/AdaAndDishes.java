package Codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AdaAndDishes {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int time;
            int a[] = new int[n];
            String line = br.readLine();
            String[] strs = line.trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(strs[i]);
            }
            Arrays.sort(a);
            if (n == 1) time = a[0];
            else if (n == 2) time = Math.max(a[0], a[1]);
            else if (n == 3) {
                time = Math.max(a[2], a[1] + a[0]);
            } else {
                time = Math.min(Math.max(a[0] + a[3], a[2] + a[1]), Math.max(a[3], a[0] + a[1] + a[2]));
            }
            System.out.println(time);
        }
    }
}
