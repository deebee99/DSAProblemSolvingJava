package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k == 0 && n != 0) return result;

        List<Integer> temp = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            temp.clear();
            temp.add(i);
            search(i, i, k - 1, temp, i + 1,n);
        }
        return result;
    }

    private void search(int i, int sum, int k, List<Integer> temp, int nextStart,int num) {

        if (k == 0) {
            if (sum == num) result.add(new ArrayList<>(temp));
            return;
        }
        if (sum > num) return;

        for (int j = nextStart; j <= 9; j++) {
            temp.add(j);
            search(j, sum + j, k - 1, temp, j + 1,num);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {

        System.out.println(new CombinationSumIII().combinationSum3(3, 9).toString());
    }
}

