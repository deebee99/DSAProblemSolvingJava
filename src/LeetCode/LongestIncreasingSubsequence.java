package LeetCode;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLISUsingInBuiltFunction(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
        }

        return len;
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        if(n<=1) return n;
        int dp[]=new int[n];

        int length=1;
        dp[0]=nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]<dp[0]) dp[0]=nums[i];
            else if(nums[i]>dp[length-1]) dp[length++]=nums[i];
            else{
                int index=findCeiling(dp,-1,length-1,nums[i]);
                dp[index]=nums[i];
            }
        }
        return length;
    }

    private int findCeiling(int dp[],int low, int high, int key) {
        while(low<high-1){
            int mid=low+(high-low)/2;
            if(dp[mid]<key) low=mid;
            else high =mid;
        }
        return high;
    }
}
