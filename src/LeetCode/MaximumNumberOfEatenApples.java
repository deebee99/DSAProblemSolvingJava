package LeetCode;

import java.util.TreeMap;
import java.util.TreeSet;

public class MaximumNumberOfEatenApples {
    public int eatenApples(int[] apples, int[] days) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int daysCount = 0;
        for (int i = 0; i < apples.length; i++) {
            int maxDays = i + days[i] - 1;
            map.put(maxDays, map.getOrDefault(maxDays, 0) + 1);
            Integer ceiling = map.ceilingKey(i);
            if (ceiling != null) {
                daysCount++;
                map.put(ceiling, map.get(ceiling) - 1);
                if (map.get(ceiling) == 0) map.remove(ceiling);
            }
        }
        for (int i = apples.length;;i++) {

            Integer ceiling = map.ceilingKey(i);
            if (ceiling != null) {
                daysCount++;
                map.put(ceiling, map.get(ceiling) - 1);
                if (map.get(ceiling) == 0) map.remove(ceiling);
            }
            else break;
        }
        return daysCount;
    }
}

