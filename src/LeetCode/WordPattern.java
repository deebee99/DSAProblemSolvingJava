package LeetCode;

import java.util.HashMap;
import java.util.HashSet;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String words[]=str.split(" ");
        HashMap<Character,String> hashMap=new HashMap<>();
        HashSet<String> hashSet=new HashSet<>();

        int n=words.length;
        if(n==0 && pattern.length()==0) return true;
        if(n==0 || pattern.length()==0) return false;
        if(pattern.length()!=words.length) return false;

        for(int i=0;i<n;i++){
            final char key = pattern.charAt(i);
            if(!hashMap.containsKey(key)) {
                if(hashSet.contains(words[i])) return false;
                hashMap.put(key,words[i]);
                hashSet.add(words[i]);
            }
            else{
                if(!hashMap.get(key).equals(words[i])) return false;
            }
        }
        return true;
    }
}
