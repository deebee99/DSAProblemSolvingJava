package LeetCode;

import java.util.Arrays;

public class HouseRobberII {
    private int dp[];
    public int rob(int[] nums) {
    int n=nums.length;
    dp=new int[n];
    int k=0,max=nums[0];
        Arrays.fill(dp,-1);
   max=robHelper(nums,0,n-2);
   Arrays.fill(dp,-1);
        max=Math.max(robHelper(nums,1,n-1),max);
        return max;
    }

    private int robHelper(int[] nums, int start, int end) {
        if(start>end) return 0;
        if(dp[start]!=-1) return dp[start];

        dp[start]=Math.max(nums[start]+robHelper(nums,start+2,end),robHelper(nums,start+1,end));
        return dp[start];
    }

    public static void main(String[] args) {
        int arr[]={1,13,1,5,6};
        System.out.println(new HouseRobberII().rob(arr));
    }
}
