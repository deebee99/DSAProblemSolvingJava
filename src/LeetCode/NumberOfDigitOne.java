package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NumberOfDigitOne {
    private ArrayList<Integer> digits;
    private int[][][] dp;
    public int countDigitOne(int n) {
        digits=new ArrayList<>();

        while(n>0){
            digits.add(n%10);
            n=n/10;
        }

        dp=new int[digits.size()][digits.size()][2];
        for(int i=0;i<digits.size();i++)
            for(int j=0;j<digits.size();j++)
                Arrays.fill(dp[i][j],-1);

        Collections.reverse(digits);
        return countDigitsOneHelper(0,1,0);
    }

    private int countDigitsOneHelper(int index,int flag,int count) {
        if(index>=digits.size()){
            return count;
        }
        if(dp[index][count][flag]!=-1) return dp[index][count][flag];
        int limit=9,ans=0;
        if(flag==1) limit=digits.get(index);

        for(int i=0;i<=limit;i++){
            int newFlag=flag;
            if(newFlag==1 && i<limit) newFlag=0;
            if(i==1) ans+=countDigitsOneHelper(index+1,newFlag,count+1);
            else ans+=countDigitsOneHelper(index+1,newFlag,count);
        }
        return dp[index][count][flag]=ans;
    }
}
