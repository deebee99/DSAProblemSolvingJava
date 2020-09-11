import java.util.Arrays;
import java.util.HashSet;

public class KnightDialer {
    private int mod=1000000007;
    private int total=0;
    private char dialPad[][]={{'1','2','3'},{'4','5','6'},{'7','8','9'},{'?','0','?'}};
    private int directions[][]={{-1,-2},{1,-2},{-2,-1},{2,-1},{-2,1},{-1,2},{2,1},{1,2}};
    private HashSet<String> hashSet=new HashSet<>();
    private int dp[][][];

    public int knightDialer(int n) {
        if(n==0) return 0;
        dp=new int[dialPad.length][3][n+1];
        for(int i=0;i<dialPad.length;i++){
            for(int j=0;j<3;j++){
                int temp[]=new int[n+1];
                Arrays.fill(temp,0);
                dp[i][j]=temp;
            }
        }
        for(int i=0;i<dialPad.length;i++){
            for(int j=0;j<3;j++){
                String s="";
              total=((total%mod)+(findNumber(i,j,n,s)%mod))%mod;
            }
        }
        return total;
    }

    private int findNumber(int i, int j, int n,String s) {
        if(i<0 || i>=dialPad.length || j<0 || j>2 || dialPad[i][j]=='?') return 0;
        if(n==0){
            if(!hashSet.contains(s)) {
                hashSet.add(s);
                return 1;
            }
            return 0;
        }
        if(dp[i][j][n]!=0) return dp[i][j][n];
        s+=dialPad[i][j];
        for(int k=0;k<directions.length;k++)
        dp[i][j][n]=((dp[i][j][n]%mod)+(findNumber(i+directions[k][0],j+directions[k][1],n-1,s))%mod)%mod;
        return dp[i][j][n];
    }

    public static void main(String[] args) {
        System.out.println(new KnightDialer().knightDialer(31));
    }
}
