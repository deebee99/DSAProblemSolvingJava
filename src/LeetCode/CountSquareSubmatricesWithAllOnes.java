package LeetCode;

public class CountSquareSubmatricesWithAllOnes {
    public int countSquares(int[][] matrix) {
        int squares = 0;
        for (int i = 0; i < matrix.length; i++)
            if (matrix[i][0] == 1) squares++;

        for (int j = 1; j < matrix[0].length; j++)
            if (matrix[0][j] == 1) squares++;

        System.out.println(squares);
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = Math.min(Math.min(matrix[i - 1][j - 1], matrix[i - 1][j]), matrix[i][j - 1]) + 1;
                    squares+=matrix[i][j];
                }
            }
        }
        return squares;
    }
}
