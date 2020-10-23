package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        int n = nums.length, ind = 0;
        if (k == 1) return nums;
        int ans[] = new int[n - k + 1];
        queue.add(0);

        for (int i = 1; i < k; i++) {
            while (!queue.isEmpty() && nums[queue.peekFirst()] < nums[i]) queue.pollFirst();
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) queue.pollLast();
            queue.add(i);
        }
        ans[ind++] = nums[queue.peekFirst()];

        for (int i = k; i < n; i++) {
            while (!queue.isEmpty() && (nums[queue.peekFirst()] < nums[i] || queue.peekFirst() < i - k + 1))
                queue.pollFirst();
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) queue.pollLast();
            queue.add(i);
            ans[ind++] = nums[queue.peekFirst()];
        }
        return ans;
    }
}

