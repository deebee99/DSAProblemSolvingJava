package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class PartitionArrayForMaximumSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        Map<Integer, Integer> cache = new HashMap<>();
        return helper(arr, k, 0, cache);
    }

    private int helper(int[] arr, int k, int idx, Map<Integer, Integer> cache) {
        if (idx == arr.length) {
            return 0;

        } else if (cache.containsKey(idx)) {
            return cache.get(idx);

        }

        int maxSoFar = 0,
                maxSumSoFar = 0;

        for (int i = idx; i < idx + k && i < arr.length; i++) {
            maxSoFar = Math.max(maxSoFar, arr[i]);
            maxSumSoFar = Math.max(maxSumSoFar, maxSoFar*(i - idx + 1) + helper(arr, k, i+1, cache));
        }

        cache.put(idx, maxSumSoFar);
        return maxSumSoFar;
    }

    /**
     * Another way of doing it.
     * @param arr
     * @param k
     * @return
     */
    public int maxSumAfterPartitioning2(int[] arr, int k) {
        int n=arr.length;
        int dp[]=new int[n]; //dp[i] represents max sum till i-th position
        int max=0;
        int i=0;
        //Fill the first k positions with max element till i-th position times number of elements
        for(;i<k&&i<n;i++){
            max=Math.max(max,arr[i]);
            dp[i]=max*(i+1);
        }
        //Start filling the rest of dp array
        for(;i<n;i++){
            max=0;
            int sum=0; //sum to keep max sum possible

            for(int j=i;j>i-k;j--){
                max=Math.max(max,arr[j]);
                sum=Math.max(sum,dp[j-1]+max*(i-j+1));
            }
            //update dp[i] with the max sum possible
            dp[i]=sum;
        }
        return dp[n-1];
    }
}
