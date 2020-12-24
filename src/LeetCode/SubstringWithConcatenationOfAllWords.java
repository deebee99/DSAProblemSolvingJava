package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> wordsMap = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for (final String word : words) wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        int wordLength = words[0].length(), stringLength = s.length();

        for (int i = 0; i < stringLength - (wordLength * words.length) + 1; i++) {
            int j = i;
            String word = "";
            Map<String, Integer> tempMap = new HashMap<>(wordsMap);
            while (true) {
                if (j + wordLength > s.length()) break;
                word = s.substring(j, j + wordLength);
                j += wordLength;
                if (tempMap.containsKey(word)) tempMap.put(word, tempMap.get(word) - 1);
                else break;
                if (tempMap.get(word) == 0) tempMap.remove(word);
            }
            if (tempMap.size() == 0)
                ans.add(i);
        }
        return ans;
    }


}
