import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Using hashmap increase time and space complexity. So used a 3D array.
 */

public class OutOfBoundaryPaths {
    private final int mod= (int) (Math.pow(10,9)+7);
    private int rows,cols;
    Map<String,Integer> map=new HashMap<>();
    int dp[][][];
    public int findPaths(int n, int m, int N, int i, int j) {
        rows=n;
        cols=m;
        if(!checkBoundary(i,j) || N==0) return 0;
        dp=new int[rows+1][cols+1][N+1];
        for(int p=0;p<=rows;p++)
            for(int q=0;q<=cols;q++)
                Arrays.fill(dp[p][q],-1);

        int ans=findPathsHelper(i,j,N);
        return ans;
    }

    private int findPathsHelper(int i, int j, int n) {
        if(!checkBoundary(i,j)) return 1;
        if(n==0) return 0;
        int ans=0;
        String s="";
       /* s+=i+","+j+","+n;
        if(map.containsKey(s)) return map.get(s);*/
        if(dp[i][j][n]!=-1) return dp[i][j][n];
        ans=findPathsHelper(i+1,j,n-1)%mod;
        ans=((ans%mod)+(findPathsHelper(i-1,j,n-1)%mod))%mod;
        ans=((ans%mod)+(findPathsHelper(i,j+1,n-1)%mod))%mod;
        ans=((ans%mod)+(findPathsHelper(i,j-1,n-1)%mod))%mod;
       // map.put(s,ans);
        dp[i][j][n]=ans;
        return ans;
    }

    private boolean checkBoundary(int i, int j){
        if(i<0 || j<0 || i>=rows || j>=cols) return false;
        return true;
    }
}
