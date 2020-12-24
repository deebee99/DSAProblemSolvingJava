package LeetCode;

public class MaximizeDistanceToClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int len = 0, maxLen = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) len++;
            else {
                if (len > maxLen) maxLen = len;
                len = 0;
            }
        }
        if (len > maxLen) maxLen = len;

        int ans = maxLen % 2 == 0 ? maxLen / 2 : maxLen / 2 + 1;

        len = 0;
        for (int i = seats.length - 1; i >= 0; i--) {
            if (seats[i] == 1) break;
            len++;
        }
        ans = Math.max(len, ans);

        len = 0;
        for (int seat : seats) {
            if (seat == 1) break;
            len++;
        }

        return Math.max(len, ans);
    }
}