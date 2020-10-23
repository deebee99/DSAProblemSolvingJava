package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class DetectPatternofLengthMRepeatedKorMoreTimes {
    public boolean containsPattern(int[] arr, int m, int freq) {
        if(m>arr.length || m*freq>arr.length) return false;
        HashMap <String,Integer> hashMap=new HashMap<>();
        int n=arr.length;
        for(int i=0;i<m;i++){
            String r="";
            int count=1;
            int j;
            for(j=i;j<i+m;j++){
                r+=arr[j]+",";
            }

            while(j+m<=n){
                String temp="";
                int k;
                for(k=j;k<j+m;k++){
                    temp+=arr[k]+",";
                }
                j=k;
                if(temp.equals(r)) count++;
                else{
                    if(count>=freq) return true;
                    count=1;
                    r=temp;
                }
                if(count>=freq) return true;
            }
        }
    return false;
    }
}
