package LeetCode;

public class MaximumScoreWordsFormedByLetters {
    private int ans = 0;
    String[] words;
    int[] score;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int freq[] = new int[26];
        this.words = words;
        this.score = score;
        for (char ch : letters) freq[ch - 'a']++;
        helper(0, freq, 0);
        return ans;
    }

    void helper(int index, int[] letters, int sum) {
        if (index == words.length) {
            ans = Math.max(ans, sum);
            return;
        }
        int flag = 0;
        int freq[] = new int[26];
        int tempScore = 0;
        for (char ch : words[index].toCharArray()) {
            freq[ch - 'a']++;
            tempScore += score[ch - 'a'];
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] > letters[i]) {
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            for (int i = 0; i < 26; i++) letters[i] -= freq[i];
            helper(index + 1, letters, sum + tempScore);
            for (int i = 0; i < 26; i++) letters[i] += freq[i];
        }
        helper(index + 1, letters, sum);
    }
}
