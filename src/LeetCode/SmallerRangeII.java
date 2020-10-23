package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class SmallerRangeII {
    int diff=Integer.MAX_VALUE;
    public int smallestRangeII(int[] A, int k) {
        Arrays.sort(A);
   int n=A.length;
   int max=A[n-1],min=A[0];
   diff=max-min;
    for(int i=0;i<n-1;i++){
        min=Math.min(A[0]+k,A[i+1]-k);
        max=Math.max(A[n-1]-k,A[i]+k);
        diff=Math.min(diff,max-min);
    }
    return diff;
    }

}
