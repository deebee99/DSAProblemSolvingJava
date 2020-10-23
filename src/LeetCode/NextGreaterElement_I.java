package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement_I {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int ans[] = new int[n1];
        if (n1 == 0 || n2 == 0) return ans;
        Map<Integer, Integer> map = new HashMap<>();

        map.put(nums2[n2 - 1], -1);
        Stack<Integer> stack = new Stack<>();
        stack.push(nums2[n2 - 1]);
        for (int i = n2 - 2; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= nums2[i]) stack.pop();
            if (stack.empty()) map.put(nums2[i], -1);
            else map.put(nums2[i], stack.peek());
            stack.push(nums2[i]);
        }
        for (int i = 0; i < n1; i++) ans[i] = map.get(nums1[i]);
        return ans;
    }

    public static void main(String[] args) {
        int nums1[] = {4, 1, 2};
        int nums2[] = {1, 3, 4, 2};
        int ans[] = new NextGreaterElement_I().nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(ans));
    }
}
