package LeetCode;

import java.util.Arrays;

public class NumberOfDiceRollsWithTargetSum {
    private int modulo=1000000007;
    private int dices,faces,total,count=0;
    private int dp[][];
    public int numRollsToTarget(int d, int f, int target) {
        dices=d;
        faces=f;
        total=target;
        dp=new int[d+1][];
        for(int i=0;i<=d;i++) {
            dp[i]=new int[target+1];
            Arrays.fill(dp[i],-1);
        }
        return calc(0,0);

    }

    private int calc(int diceNo, int sumSoFar) {
        if(diceNo==dices){
            if(sumSoFar==total) return 1;
            return 0;
        }
        if(sumSoFar>total) return 0;
        if(dp[diceNo][sumSoFar]!=-1) return dp[diceNo][sumSoFar];
        int ans=0;
        for(int i=1;i<=faces;i++)
            ans=((ans%modulo)+(calc(diceNo+1,sumSoFar+i)%modulo))%modulo;
        dp[diceNo][sumSoFar]=ans;
        return ans;
    }
}
