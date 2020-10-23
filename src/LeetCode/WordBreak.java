package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    Set<String> set=new HashSet<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        set.addAll(wordDict);
    int n=s.length();
    boolean isPresent[]=new boolean[n+2];
    isPresent[n]=true;
    for(int i=n-1;i>=0;i--){
        String temp="";
        for(int j=i;j<n;j++){
            temp+=s.charAt(j);
            if(set.contains(temp) && isPresent[j+1]==true){
                isPresent[i]=true;
                break;
            }
        }
    }
    //for(boolean b : isPresent) System.out.print(" "+b);
    return isPresent[0];
    }

    public static void main(String[] args) {
        WordBreak wordBreak=new WordBreak();

        final String[] strings = {"apple", "pen"};
        boolean result = wordBreak.wordBreak("applepenapple", Arrays.asList(strings));
        System.out.println(result);
    }
}
