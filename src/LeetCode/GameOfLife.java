package LeetCode;

public class GameOfLife {
    private int m,n;
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;
        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lives = neighborsActive(board,i, j);
                if (board[i][j] == 1 && lives >= 2 && lives <= 3)
                    board[i][j] = 3;

                if (board[i][j] == 0 && lives == 3)
                    board[i][j] = 2;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    public int neighborsActive(int[][] board,int i, int j) {
        int lives = 0;
        for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++)
            for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++)
                lives += board[x][y] & 1;

        lives -= board[i][j];
        return lives;
    }
}
