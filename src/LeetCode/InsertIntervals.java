package LeetCode;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class InsertIntervals {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] arr = getInts(intervals, newInterval);
        if (arr != null) return arr;
        List<Pair<Integer, Integer>> temp = new ArrayList<>();
        List<Pair<Integer, Integer>> result = new ArrayList<>();
        int inserted = 0;
        for (int i = 0; i < intervals.length; i++) {

            if (intervals[i][0] > newInterval[0] && inserted == 0) {
                temp.add(new Pair<>(newInterval[0], newInterval[1]));
                inserted = 1;
            }

            temp.add(new Pair<>(intervals[i][0], intervals[i][1]));
        }
        if (inserted == 0) temp.add(new Pair<>(newInterval[0], newInterval[1]));

        for (int i = 0; i < temp.size(); i++) {

            int flag = 0;
            Pair<Integer, Integer> cur1 = temp.get(i), cur2 = null;
            int start = cur1.getKey();
            int end = cur1.getValue();

            i++;
            while (i < temp.size()) {
                cur2 = temp.get(i);
                if (cur2.getKey() <= end) {
                    end = Math.max(end, cur2.getValue());
                } else {
                    result.add(new Pair<>(start, end));
                    flag = 1;
                    break;
                }
                i++;
            }
            if (flag == 0)
                result.add(new Pair<>(start, end));

            i--;
        }
        int ans[][] = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            int a[] = {result.get(i).getKey(), result.get(i).getValue()};
            ans[i] = a;
        }
        return ans;
    }

    public int[][] insert2(int[][] intervals, int[] newInterval) {
        int[][] arr = getInts(intervals, newInterval);
        if (arr != null) return arr;
        List<int[]> temp = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][1] < newInterval[0]) temp.add(intervals[i]);
            else if (intervals[i][0] > newInterval[1]) {
                temp.add(newInterval);
                newInterval = intervals[i];
            } else if (intervals[i][1] >= newInterval[0] || intervals[i][0] <= newInterval[1]) {
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        temp.add(newInterval);

        int[][] ans = new int[temp.size()][2];
        for (int i = 0; i < temp.size(); i++) {
            int a[] = {temp.get(i)[0], temp.get(i)[1]};
            ans[i] = a;
        }
        return ans;
    }

    private int[][] getInts(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0 && newInterval.length == 0) return new int[][]{{}};
        if (intervals.length == 0) {
            int arr[][] = new int[1][2];
            int a[] = {newInterval[0], newInterval[1]};
            arr[0] = a;
            return arr;
        }
        return null;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {3, 5}, {4, 8}, {6, 7}, {8, 10}, {12, 16}};
        int newInterval[] = {};
        int[][] arr = new InsertIntervals().insert(intervals, newInterval);
        System.out.println();
        System.out.print("(");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i][0] + "," + arr[i][1] + ") (");

    }
}

