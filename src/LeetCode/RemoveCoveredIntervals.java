package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        int count = 1;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                boolean comp = o1[0] == o2[0] ? o1[1] < o2[1] : o1[0] > o2[0];
                if (comp) return 1;
                return -1;
            }
        });

        int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (prev[0] <= intervals[i][0] && prev[1] >= intervals[i][1])
                continue;

            prev = intervals[i];
            count++;
        }
        return count;
    }
}
