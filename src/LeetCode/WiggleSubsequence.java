package LeetCode;

public class WiggleSubsequence {
    /**
     * O(N^2) solution
     * @param nums
     * @return
     */
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length, ans = 0;
        if (n <= 1) return n;
        int[] lisPositive = new int[n];
        int[] lisNegative = new int[n];

        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) lisPositive[i] = Math.max(lisPositive[i], lisNegative[j] + 1);
                else if (nums[i] < nums[j]) lisNegative[i] = Math.max(lisNegative[i], lisPositive[j] + 1);
            }
            ans = Math.max(ans, Math.max(lisNegative[i], lisPositive[i]));
        }
        return ans + 1;
    }

    /**
     * O(N) solution
     */
    public int wiggleMaxLength2(int[] nums) {
                if (nums.length < 2)
                    return nums.length;
                int down = 1, up = 1;
                for (int i = 1; i < nums.length; i++) {
                    if (nums[i] > nums[i - 1])
                        up = down + 1;
                    else if (nums[i] < nums[i - 1])
                        down = up + 1;
                }
                return Math.max(down, up);
            }
}
