package LeetCode;

public class LargestSumOfAverages {
        private double dp[][]=new double[100][100];
        public double largestSumOfAverages(int[] arr, int k) {
            return largestSumOfAveragesHelper(0,arr,k);

        }

        private double largestSumOfAveragesHelper(int index, int[] arr, int k) {

            if(index==arr.length) return 0;
            int s=0;
            if(k==1) {
                for (int i = index; i < arr.length; i++) s += arr[i];
                double d = (double) s / (arr.length - index);
                return d;
            }


            if(dp[index][k]>0) return dp[index][k];
            for(int i=index;i<arr.length;i++){
                s+=arr[i];
                double d=(double)s/(i-index+1);
                dp[index][k]=Math.max(dp[index][k],largestSumOfAveragesHelper(i+1,arr,k-1)+d);
            }

            return dp[index][k];
        }
}
