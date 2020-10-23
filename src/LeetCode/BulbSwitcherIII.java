package LeetCode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BulbSwitcherIII {

    /**
     * O(N) solution
     * @param light
     * @return
     */
    public int numTimesAllBlue(int[] light) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        int n = light.length;
        int[] status = new int[n + 1];
        for (int index : light) {
            if ((index == 1) || (index > 1 && status[index - 1] == 2)) {
                status[index] = 2;

                for (int i = index + 1; i <= n; i++) {
                    if (status[i] == 0) break;
                    status[i] = 2;
                    set.remove(i);
                }
            } else {
                set.add(index);
                status[index] = 1;
            }

            if (set.size() == 0) count++;
        }
        return count;
    }

    /**
     * O(N) solution
     */
    public int numTimesAllBlue2(int[] light) {
        int moments = 0;

        int maxBulb = Integer.MIN_VALUE;
        int turnedOnCount = 0;
        for (int bulb : light) {
            turnedOnCount++;
            maxBulb = Math.max(maxBulb, bulb);
            if (maxBulb == turnedOnCount) moments++;
        }
        return moments;
    }
}
