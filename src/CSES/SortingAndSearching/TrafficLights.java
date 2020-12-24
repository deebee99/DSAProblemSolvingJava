package CSES.SortingAndSearching;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Stream;

public class TrafficLights {
    static int x, n;
    static int[] arr;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        x = Integer.parseInt(s[0]);
        n = Integer.parseInt(s[1]);
        TreeSet<Integer> set = new TreeSet<>();

        arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        set.add(0);
        set.add(x);
        TreeMap<Integer, Integer> gaps = new TreeMap<>();

        OutputStream out = new BufferedOutputStream(System.out);

        for (int i : arr) {
            Integer floor = set.floor(i);
            Integer ceil = set.ceiling(i);
            int gap = ceil - floor;
            if (gaps.containsKey(gap)) {
                gaps.put(gap, gaps.get(gap) - 1);
                if (gaps.get(gap) == 0) gaps.remove(gap);
            }
            gaps.put(i - floor, gaps.getOrDefault(i - floor, 0) + 1);
            gaps.put(ceil - i, gaps.getOrDefault(ceil - i, 0) + 1);
            set.add(i);
            out.write((gaps.lastKey() + " ").getBytes());
        }
        out.flush();
    }
}
