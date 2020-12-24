package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class StrobogrammaticNumberII {
    public List<String> findStrobogrammatic(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 1) {
            ans.add("0");
            ans.add("1");
            ans.add("8");
            return ans;
        }
        String digits[] = {"0", "1", "6", "8", "9"};
        int mid = n / 2;
        construct(0, mid, n, digits, ans, new StringBuilder());

        return ans;
    }

    private void construct(int index, int mid, int n, String[] digits, List<String> ans, StringBuilder s) {
        if (index == mid) {
            if (n % 2 == 1) {
                for (String temp : digits) {
                    if (temp.equals("6") || temp.equals("9")) continue;
                    StringBuilder t = new StringBuilder(s);
                    t.append(temp);
                    for (int i = s.length() - 1; i >= 0; i--) {
                        if (s.charAt(i) == '6') t.append('9');
                        else if (s.charAt(i) == '9') t.append('6');
                        else t.append(s.charAt(i));
                    }
                    ans.add(t.toString());
                }
            } else {
                StringBuilder t = new StringBuilder(s);
                for (int i = s.length() - 1; i >= 0; i--) {
                    if (s.charAt(i) == '6') t.append('9');
                    else if (s.charAt(i) == '9') t.append('6');
                    else t.append(s.charAt(i));
                }
                ans.add(t.toString());
            }
            return;
        }
        int start = index == 0 ? 1 : 0;
        for (; start < digits.length; start++) {
            construct(index + 1, mid, n, digits, ans, new StringBuilder(s).append(digits[start]));
        }

    }
}