package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DivisorGame {

    private int canWin[];
    public boolean divisorGame(int n) {
    canWin=new int[n+1];
    Arrays.fill(canWin,-1);
    return divisorGameHelper(n);
    }

    private boolean divisorGameHelper(int n) {
        if(n<=1) return false;
        if(canWin[n]!=-1) return canWin[n] != 0;
        for(int i=1;i<n;i++){
            if(n%i==0){
                boolean ans=divisorGameHelper(n-i);
                if(!ans) {
                    canWin[n]=1;
                    return true;
                }
            }
        }
        canWin[n]=0;
        return false;
    }
}
