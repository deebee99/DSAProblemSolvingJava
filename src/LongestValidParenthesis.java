import java.util.Stack;

public class LongestValidParenthesis {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == ')') {
                stack.pop();
                if (!stack.isEmpty()) {
                    ans = Math.max(ans, i - stack.peek());
                }
                else stack.push(i);
            } else stack.push(i);
        }
        return ans;
    }
}

