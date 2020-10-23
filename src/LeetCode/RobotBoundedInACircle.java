package LeetCode;

public class RobotBoundedInACircle {

    // 0: up (north) , 1: right, 2: down, 3: left
    public boolean isRobotBounded(String instructions) {
        int[] currPosition = new int[] {0, 0};
        int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int d = 0;

        for (int i=0;i<instructions.length();i++) {
            char ch = instructions.charAt(i);
            if (ch == 'G') {
                currPosition[0] += directions[d][0];
                currPosition[1] += directions[d][1];
            } else if (ch == 'L') {
                d = (d + 3) % 4;
            } else {
                d = (d + 1) % 4;
            }
        }
        return currPosition[0] == 0 && currPosition[1] == 0 || d!=0;
    }
}
