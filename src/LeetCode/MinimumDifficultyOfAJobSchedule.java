package LeetCode;

public class MinimumDifficultyOfAJobSchedule {
    int dp[][];
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n=jobDifficulty.length;
        if(n<d) return -1;
        if(n==d){
            int sum=0;
            for(int job : jobDifficulty) sum+=job;
            return sum;
        }
        dp=new int[n+1][d+1];
        return minDifficultyHelper(jobDifficulty,0,d,jobDifficulty.length);
    }

    private int minDifficultyHelper(int jobDifficulty[], int i, int d, int n) {
        if(d == 0 && i == n) return 0;
        if(d == 0 || i == n) return Integer.MAX_VALUE;
        if(dp[i][d] != -1) return dp[i][d];
        int currMax = jobDifficulty[i];
        int min = Integer.MAX_VALUE;
        for(int j = i; j < n; j++) {
            currMax = Math.max(jobDifficulty[j], currMax);
            int temp = minDifficultyHelper(jobDifficulty,j + 1, d - 1, n);
            min = Math.min(min, temp + currMax);
        }
        return dp[i][d] = min;
    }
}

