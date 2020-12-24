package LeetCode;

import java.util.TreeMap;

public class AdvantageShuffle {
    public int[] advantageCount(int[] A, int[] B) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] ans = new int[A.length];
        for (int i : A) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int index = 0;
        for (int i = 0; i < B.length; i++) {
            Integer ceiling = map.ceilingKey(B[i] + 1);
            if (ceiling == null) {
                final Integer firstKey = map.firstKey();
                ans[index++] = firstKey;
                map.put(firstKey, map.get(firstKey) - 1);
                if (map.get(firstKey) == 0) map.remove(firstKey);
            }
            else {
                ans[index++] = ceiling;
                map.put(ceiling, map.get(ceiling) - 1);
                if (map.get(ceiling) == 0) map.remove(ceiling);
            }
        }
        return ans;
    }
}
