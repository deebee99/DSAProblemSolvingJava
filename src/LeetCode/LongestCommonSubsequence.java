package LeetCode;

public class LongestCommonSubsequence {
    /**
     * Space Optimized Solution O(min(m,n));
     * @param s1 of length n
     * @param s2 of length m
     * @return longest common subsequence in s1 and s2.
     */
    public int longestCommonSubsequence(String s1, String s2) {
        if(s1.length()<s2.length()) return longestCommonSubsequence(s2,s1);
        int dp[][]=new int[2][s2.length()+1];

        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i%2][j]=dp[(i-1)%2][j-1]+1;
                else dp[i%2][j]=Math.max(dp[(i-1)%2][j],dp[i%2][j-1]);
            }
        }

        return dp[s1.length()%2][s2.length()];
    }
}
