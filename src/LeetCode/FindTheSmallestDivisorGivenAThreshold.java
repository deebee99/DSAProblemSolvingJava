package LeetCode;

/**
 * Binary Search Problem
 */
public class FindTheSmallestDivisorGivenAThreshold {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = nums[0];
        for (int n : nums) high = Math.max(n, high);
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int tempSum = calcSum(nums, mid);

            if (tempSum <= threshold) {
                ans = mid;
                high = mid - 1;
            } else low = mid + 1;
        }
        return ans;
    }

    private int calcSum(int[] nums, int mid) {
        int sum = 0;
        for (int n : nums) {
            sum += n / mid;
            if (n % mid != 0) sum++;
        }
        return sum;
    }
}