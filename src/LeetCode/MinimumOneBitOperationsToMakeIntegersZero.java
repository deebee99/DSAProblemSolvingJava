package LeetCode;

import java.util.Arrays;

public class MinimumOneBitOperationsToMakeIntegersZero {
    private int dp[]=new int[32];
    private String zero="";

    public int minimumOneBitOperations(int n) {
        StringBuilder binary=new StringBuilder(Integer.toBinaryString(n));
        Arrays.fill(dp,Integer.MIN_VALUE);
        int arr[]=new int[32];
        for(int i=0;i<32;i++){
            zero+='0';
            arr[i]=((1<<i)&n)>0 ? 1 : 0;
            System.out.print(arr[i]);
        }
        return helper(0,binary,0);

    }

    private int helper(int i,StringBuilder s,int count) {
        if(s.toString().equals(zero)) return count;
        if(i==32) return Integer.MAX_VALUE;
        if(dp[i]!=Integer.MIN_VALUE) return dp[i];
        StringBuilder s1=new StringBuilder(s);
        s1.append(s1.charAt(s1.length()-1)=='1'?'0' : '1');
        s1.deleteCharAt(s1.length()-2);
        dp[i]=helper(i,s1,count+1);
        if(i>0) {
            int n = Integer.parseInt(s.toString(), 2);
            if ((n&(1<<i-1))>0){
                int flag=0;
                for(int j=i-2;j>=0;j--){
                    if((n&(1<<i-1))>0){
                        flag=1;
                        break;
                    }
                }
                if(flag==0) {
                    StringBuilder s2 = new StringBuilder(s);
                    s2.setCharAt(i,s2.charAt(i)=='1'?'0' : '1');
                    dp[i]=Math.min(dp[i],helper(i+1,s1,count+1));
                }
            }
        }
        return dp[i];
    }
}
