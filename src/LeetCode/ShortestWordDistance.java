package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistance {
    class Solution {
        public int shortestDistance(String[] words, String word1, String word2) {
            Map<String, List<Integer>> map = new HashMap<>();
            int index = 0;
            for (String word : words) {
                if (!map.containsKey(word)) map.put(word, new ArrayList<>());
                map.get(word).add(index++);
            }
            int ans = Integer.MAX_VALUE;
            for (int i : map.get(word1)) {
                int low = 0, high = map.get(word2).size() - 1;
                while (low <= high) {
                    int mid = low + (high - low) / 2;
                    int j = map.get(word2).get(mid);
                    ans = Math.min(ans, Math.abs(j - i));

                    if (j > i) high = mid - 1;
                    else low = mid + 1;
                }
            }
            return ans;
        }
    }
}