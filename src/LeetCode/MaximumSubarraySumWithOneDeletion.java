package LeetCode;

public class MaximumSubarraySumWithOneDeletion {
    public int maximumSum(int[] arr) {
        int max1 = arr[0] , max0 = arr[0] , ans = arr[0];
        for(int i=1;i<arr.length;i++){
            max1 = Math.max(max1+arr[i] , Math.max(arr[i] , max0) );
            max0 = Math.max(max0+arr[i] , arr[i]);
            ans = Math.max(ans,max1);
        }
        return ans;
    }
}
