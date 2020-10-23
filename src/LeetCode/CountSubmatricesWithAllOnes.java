package LeetCode;

import javafx.util.Pair;

public class CountSubmatricesWithAllOnes {
    Pair<Integer,Integer> dp[][]=new Pair[150][150];
    public int numSubmat(int[][] matrix) {
        int squares = matrix[0][0];
        for (int i = 1; i < matrix.length; i++){
            if (matrix[i][0] == 1){
                matrix[i][0]+=matrix[i-1][0];
                squares+=matrix[i][0];
            }
            System.out.println(squares);
        }

        for (int j = 1; j < matrix[0].length; j++){
            if (matrix[0][j] == 1){
                matrix[0][j]+=matrix[0][j-1];
                squares+=matrix[0][j];
            }
            System.out.println(squares);
        }


        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = Math.max(matrix[i][j - 1], matrix[i - 1][j]) + 1;
                    squares+=matrix[i][j];
                }
                System.out.println(squares);
            }
        }
        return squares;
    }
}
