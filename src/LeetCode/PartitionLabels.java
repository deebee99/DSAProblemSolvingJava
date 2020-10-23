package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result=new ArrayList<>();
        int globalFreqCount[]=new int[26];
        if(s.length()==0) return result;
        for(char ch : s.toCharArray()) globalFreqCount[ch-'a']++;
        String temp=""+s.charAt(0);
        int localFreqCount[]=new int[26];
        localFreqCount[s.charAt(0)-'a']=1;
        globalFreqCount[s.charAt(0)-'a']--;
        int count=globalFreqCount[s.charAt(0)-'a'];
        for(int i=1;i<s.length();i++){
            int charPos = s.charAt(i) - 'a';
            if(count>0) {
                temp += s.charAt(i);
                globalFreqCount[charPos]--;
                if(localFreqCount[charPos]==0) {
                    count += globalFreqCount[charPos];
                    localFreqCount[charPos]=1;
                }
                else count--;

            }
            else{
                Arrays.fill(localFreqCount,0);
                result.add(temp.length());
                localFreqCount[charPos]=1;
                temp=""+s.charAt(i);
                globalFreqCount[charPos]--;
                count = globalFreqCount[charPos];
            }
        }
        result.add(temp.length());
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new PartitionLabels().partitionLabels("ababcbacadefegdehijhklij"));
    }
}
