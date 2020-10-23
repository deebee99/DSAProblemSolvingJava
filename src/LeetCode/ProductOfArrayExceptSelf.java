package LeetCode;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1, zero = 0;
        for (int i : nums) {
            if (i == 0) zero++;
            else prod *= i;

        }
        int ans[] = new int[nums.length];
        if (zero > 1) prod = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) ans[i] = prod;
            else if (zero >= 1) ans[i] = 0;
            else ans[i] = prod / nums[i];
        }
        return ans;
    }

    /**
     * Without using division operator and in O(1) space, O(N) time
     */
    class Solution {
        public int[] productExceptSelf(int[] nums) {

            int length = nums.length;
            int[] answer = new int[length];

            answer[0] = 1;
            for (int i = 1; i < length; i++) answer[i] = nums[i - 1] * answer[i - 1];

            int R = 1;
            for (int i = length - 1; i >= 0; i--) {
                answer[i] = answer[i] * R;
                R *= nums[i];
            }

            return answer;
        }
    }
}
