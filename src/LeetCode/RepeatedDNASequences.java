package LeetCode;

import java.util.*;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {

        List<String> ans = new ArrayList<>();
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i+10<=s.length();i++){
            String temp=s.substring(i,i+10);
            map.put(temp,map.getOrDefault(temp,1));
        }
        for(Map.Entry<String,Integer> entry : map.entrySet())
            if(entry.getValue()>1) ans.add(entry.getKey());

        return ans;
    }
}
