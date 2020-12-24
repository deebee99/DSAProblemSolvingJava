package CSES.SortingAndSearching;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class FactoryMachines {
    static int n, k;
    static int[] arr;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);

        arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(calculate());
    }

    /**
     * Binary Search solution.
     * @return
     */
    static long calculate() {
        long lo = 0;
        long hi = Long.MAX_VALUE;
        long ans = 0;
        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            //System.out.println(mid);
            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += (mid / arr[i]);
                if (sum >= k) {
                    break;
                }
            }
            if (sum >= k) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    /**
     * Used Priority Queue
     * Gave TLE
     *
     * @return
     */
    static long calculateII() {
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> {
            return (int) (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        });
        long time = Long.MIN_VALUE;
        for (int i : arr) pq.add(new long[]{i, i});
        while (k-- > 0) {
            long[] cur = pq.poll();
            time = Math.max(time, cur[0]);
            pq.add(new long[]{cur[0] + cur[1], cur[1]});
        }
        return time;
    }
}
