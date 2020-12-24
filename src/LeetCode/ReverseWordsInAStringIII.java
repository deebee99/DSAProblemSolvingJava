package LeetCode;

public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        String ans = "";
        for (int i = 0; i < words.length; i++) {
            StringBuilder temp = new StringBuilder(words[i]).reverse();
            ans += temp.toString();
        }
        return ans;
    }
}
