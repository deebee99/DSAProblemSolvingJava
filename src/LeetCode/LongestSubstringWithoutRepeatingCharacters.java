package LeetCode;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        final int n = s.length();
        if(n <=1) return n;

        int freq[]=new int[270];
        int start=0,length=0;
        for(int i = 0; i< n; i++){
            char ch=s.charAt(i);
            if(freq[ch]!=0){
                length=Math.max(length,i-start);
                while(freq[ch]!=0){
                    freq[s.charAt(start++)]--;
                }
            }
            freq[ch]++;
        }
        length=Math.max(length, n -start);
        return length;
    }
}
