package LeetCode;

import java.util.Arrays;

public class NumberOfLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int maxLen = 1, maxCount = 1;

        int[] count = new int[nums.length];
        int[] soFarLength = new int[nums.length];
        Arrays.fill(soFarLength, 1);
        Arrays.fill(count, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    if (count[i] < (count[j] + 1)) {
                        count[i] = count[j] + 1;
                        soFarLength[i] = soFarLength[j];
                    } else if (count[i] == count[j] + 1) soFarLength[i] += soFarLength[j];
                }
            }
            if (count[i] > maxLen) {
                maxLen = count[i];
                maxCount = soFarLength[i];
            } else if (count[i] == maxLen)
                maxCount += soFarLength[i];
        }
        return maxCount;
    }
}