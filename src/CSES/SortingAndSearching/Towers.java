package CSES.SortingAndSearching;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;
import java.util.stream.Stream;

public class Towers {
    static int n;
    static int[] arr;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);

        TreeMap<Integer, Integer> map = new TreeMap<>();
        long count = 0;
        arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < n; i++) {
            Integer ceilingKey = map.ceilingKey(arr[i] + 1);
            if (ceilingKey == null) {
                count++;
            } else {
                map.put(ceilingKey, map.get(ceilingKey) - 1);
                if (map.get(ceilingKey) == 0) {
                    map.remove(ceilingKey);
                }
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        System.out.println(count);
    }
}
