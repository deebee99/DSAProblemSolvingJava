package LeetCode;

import java.util.*;

public class MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        if (points.length <= 1) return points.length;

        Arrays.sort(points, (int[] a, int[] b) -> {
            return a[0] == b[0] ? (a[1] < b[1] ? -1 : 1) : (a[0] < b[0] ? -1 : 1);
        });
        int count = 1;

        int prev[] = points[0];
        for (int i = 1; i < points.length; i++) {
            if ((points[i][0] == prev[0] && points[i][1] == prev[1]) || (points[i][0] == prev[1])) continue;
            else if (points[i][0] < prev[1]) {
                prev[0] = Math.max(prev[0], points[i][0]);
                prev[1] = Math.min(prev[1], points[i][1]);
            } else {
                prev = points[i];
                count++;
            }
        }
        return count;
    }

}
