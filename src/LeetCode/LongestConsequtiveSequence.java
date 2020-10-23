package LeetCode;

import java.util.*;

public class LongestConsequtiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        if (nums.length == 0) return 0;
        for (int n : nums) set.add(n);
        List<Integer> temp = new ArrayList<>(set);
        int prev = temp.get(0), length = 1, ans = 1;
        for (int i = 1; i < temp.size(); i++) {
            if (temp.get(i) != prev + 1) {
                ans = Math.max(ans, length);
                length = 1;
            } else length++;
            prev = temp.get(i);
        }
        return ans = Math.max(ans, length);
    }
}
