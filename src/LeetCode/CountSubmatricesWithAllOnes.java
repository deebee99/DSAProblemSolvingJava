package LeetCode;

import javafx.util.Pair;

public class CountSubmatricesWithAllOnes {
    Pair<Integer,Integer> dp[][]=new Pair[150][150];
    public int numSubmat(int[][] matrix) {
        int squares = matrix[0][0];
        dp[0][0]=new Pair<>(matrix[0][0],matrix[0][0]);
        for (int i = 1; i < matrix.length; i++){
            if (matrix[i][0] == 1){
                int rows=dp[i-1][0].getKey()+1;
                squares+=rows;
                dp[i][0]=new Pair<>(rows,1);
            }
            else dp[i][0]=new Pair<>(0,0);
            System.out.println(squares);
        }

        for (int j = 1; j < matrix[0].length; j++){
            if (matrix[0][j] == 1){
                int cols=dp[0][j-1].getValue()+1;
                squares+=cols;
                dp[0][j]=new Pair<>(1,cols);
            }
            else dp[0][j]=new Pair<>(0,0);
            System.out.println(squares);
        }


        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = new Pair<>(dp[i][j - 1].getValue()+1,dp[i - 1][j].getKey() + 1);
                    squares+=dp[i][j].getValue()+dp[i][j].getKey()-1;
                }
                else dp[i][j]=new Pair<>(0,0);
                System.out.println(squares);
            }
        }
        print(matrix.length,matrix[0].length);
        return squares;
    }

    private void print(int n,int m){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print("("+dp[i][j].getKey()+" , "+dp[i][j].getValue()+") ");
            }
            System.out.println();
        }
    }
}
