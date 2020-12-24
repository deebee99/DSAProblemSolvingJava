package CSES.SortingAndSearching;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class SubarrayDivisibility {
    static int n;
    static int[] arr;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long mod[] = new long[n + 1];
        Arrays.fill(mod, 0l);

        long cumSum = 0;
        for (int i = 0; i < n; i++) {
            cumSum += arr[i];
            mod[(int) (((cumSum % n) + n) % n)]++;
        }

        long result = mod[0];

        for (int i = 0; i < n; i++) {
            if (mod[i] > 1)
                result += (mod[i] * (mod[i] - 1)) / 2;
        }

        System.out.println(result);
    }
}