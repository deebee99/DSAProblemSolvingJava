package LeetCode;

import java.util.HashMap;
import java.util.PriorityQueue;

public class MinimumCostTreeFromLeafValues {
    private int dp[][]=new int[16][16];
    public int mctFromLeafValues(int[] arr) {
        return mctFromLeafValuesHelper(arr,1,arr.length);
    }

    private int mctFromLeafValuesHelper(int[] arr, int i, int j) {
        if(j==i) return arr[i];
        if(dp[i][j]!=0) return dp[i][j];
int ans=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int max1=arr[i],max2=arr[k+1];
            for(int x=i;x<=k;x++)
                max1=Math.max(max1,arr[x]);
            for(int x=k+1;x<j;x++)
                max2=Math.max(max2,arr[x]);

            ans=Math.min(ans,mctFromLeafValuesHelper(arr,i,k)+mctFromLeafValuesHelper(arr,k+1,j)+max1+max2);
        }
        return dp[i][j]=ans;
    }
}
