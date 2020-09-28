public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int start = 0, prod = 1, count = 0;

        for (int i = 0; i < nums.length; i++) {
            prod = prod * nums[i];
            while (prod >= k) prod /= nums[start++];
            count += i - start + 1;
        }
        return count;
    }
}
