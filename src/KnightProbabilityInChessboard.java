import java.util.Arrays;

public class KnightProbabilityInChessboard {
    private int n;
    private int k;
    private double dp[][][];
    public double knightProbability(int N, int K, int r, int c) {
        n=N;
        k=K;
        dp=new double[n+1][n+1][k+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<n+1;j++)
                Arrays.fill(dp[i][j],-1);
        }
        return knightProbabilityHelper(r,c,0);
    }

    private double knightProbabilityHelper(int r, int c, int moves) {
        if(moves==k){
            if(r>=n || r<0 || c>=n || c<0) return 0;
            return 1;
        }
        if(r>=n || r<0 || c>=n || c<0) return 0;

        if(dp[r][c][moves]!=-1) return dp[r][c][moves];
        dp[r][c][moves]=(knightProbabilityHelper(r-2,c-1,moves+1)
                +knightProbabilityHelper(r-2,c+1,moves+1)
                +knightProbabilityHelper(r+2,c-1,moves+1)
                +knightProbabilityHelper(r+2,c+1,moves+1)
                +knightProbabilityHelper(r-1,c-2,moves+1)
                +knightProbabilityHelper(r+1,c-2,moves+1)
                +knightProbabilityHelper(r-1,c+2,moves+1)
                +knightProbabilityHelper(r+1,c+2,moves+1));
        dp[r][c][moves]=dp[r][c][moves]/(double)8;
        return dp[r][c][moves];
    }
}
