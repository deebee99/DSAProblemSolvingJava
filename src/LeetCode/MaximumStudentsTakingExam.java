package LeetCode;

import javafx.util.Pair;
import java.util.ArrayList;
import java.util.Arrays;

public class MaximumStudentsTakingExam {
    private int n, m;
    private ArrayList<Pair<Integer, Integer>> list = new ArrayList<>();

    public int maxStudents(char[][] seats) {
        n = seats.length;
        if (n != 0) m = seats[0].length;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (seats[i][j] == '.') list.add(new Pair<>(i, j));

        if (list.size() == 0) return 0;

        for (int i = 0; i < list.size(); i++) {
            char[][] grid = new char[n][m];
            for (int j = 0; j < n; j++) grid[j] = Arrays.copyOf(seats[j], m);

            ans = Math.max(ans, arrange(grid, list.get(i).getKey(), list.get(i).getValue()));
        }
        return ans;
    }

    private int arrange(char[][] seats, Integer i, Integer j) {
        if (i < 0 || i >= n || j < 0 || j >= m || seats[i][j] == '#' || seats[i][j] == '*') return 0;
        int seated = 1;
        if (j - 1 >= 0 && seats[i][j - 1] == '*') seated = 0;
        if (j + 1 < m && seats[i][j + 1] == '*') seated = 0;
        if (i - 1 >= 0 && j - 1 >= 0 && seats[i - 1][j - 1] == '*') seated = 0;
        if (i - 1 >= 0 && j + 1 < m && seats[i - 1][j + 1] == '*') seated = 0;
        if (i + 1 < n && j - 1 >= 0 && seats[i + 1][j - 1] == '*') seated = 0;
        if (i + 1 < n && j + 1 < m && seats[i + 1][j + 1] == '*') seated = 0;

        if (seated == 1) seats[i][j] = '*';
        else return 0;

        for (int ind = 0; ind < list.size(); ind++) {
            seated += arrange(seats, list.get(ind).getKey(), list.get(ind).getValue());
        }
        return seated;
    }
}