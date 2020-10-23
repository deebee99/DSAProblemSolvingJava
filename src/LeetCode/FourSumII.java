package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FourSumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> hashMapAB=new HashMap<>();
        Map<Integer,Integer> hashMapCD=new HashMap<>();
        int n=A.length,count=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                hashMapAB.put(A[i]+B[j],hashMapAB.getOrDefault(A[i]+B[j],0)+1);
                hashMapCD.put(C[i]+D[j],hashMapCD.getOrDefault(C[i]+D[j],0)+1);
            }
        }

        for(Integer key : hashMapAB.keySet()){
            Integer value=hashMapCD.get(key*(-1));
            if(value!=null) count+=hashMapAB.get(key)*value;
        }
        return count;
    }
}
