package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
            search(i + 1, n, k, list);
            list.remove(list.size() - 1);
        }

        return result;
    }

    private void search(int i, int n, int k, List<Integer> list) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int j = i; j <= n; j++) {
            list.add(j);
            search(j + 1, n, k, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new Combinations().combine(5, 3);
        System.out.println(result.toString());
    }
}
