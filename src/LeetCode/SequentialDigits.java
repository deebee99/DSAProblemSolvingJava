package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SequentialDigits {
    private List<Integer> result;

    public List<Integer> sequentialDigits(int low, int high) {
        result = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            check(i, low, high);
        }
        Collections.sort(result);
        return result;
    }

    private void check(int sum, int low, int high) {
        if (sum >= low && sum <= high) result.add(sum);
        if (sum > high) return;
        int lastDigit = sum % 10;
        if (lastDigit < 9)
            check((sum * 10) + lastDigit + 1, low, high);
    }
}
