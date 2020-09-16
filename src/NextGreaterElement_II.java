import java.util.Stack;

public class NextGreaterElement_II {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        if (n == 0) return ans;

        ans[n - 1] = -1;
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= nums[i]) stack.pop();
            System.out.println(stack.toString());
            if (stack.empty()) ans[i] = -1;
            else ans[i] = stack.peek();
            stack.push(nums[i]);
        }

        for (int i = 0; i < n; i++) {
            if (ans[i] == -1) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] > nums[i]) {
                        ans[i] = nums[j];
                        break;
                    }
                }
            }
        }

        return ans;
    }
}
