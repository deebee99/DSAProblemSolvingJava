public class MinimumScoreTriangulationOfPolygon {
    public int minScoreTriangulation(int[] A) {
        return minScoreTriangulation(0, A.length - 1, A, new int[A.length][A.length]);
    }

    private int minScoreTriangulation(int i, int k, int[] A, int[][] memo) {
        if (k - i < 2) return 0;
        if (k - i == 2) return A[i] * A[i + 1] * A[k];
        if (memo[i][k] != 0) return memo[i][k];

        int minSum = Integer.MAX_VALUE;

        for (int j = i + 1; j < k; j++) {
            minSum = Math.min(minSum, minScoreTriangulation(i, j, A, memo) + minScoreTriangulation(j, k, A, memo) + A[i] * A[j] * A[k]);
        }

        memo[i][k] = minSum;
        return minSum;
    }
}
