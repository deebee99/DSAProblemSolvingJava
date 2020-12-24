package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        List<String> postfix = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '+' || ch == '-') {
                while (!stack.isEmpty() && stack.peek() != '(') postfix.add(Character.toString(stack.pop()));

                stack.push(ch);
            } else if (ch == '(') stack.push(ch);
            else if (ch == ')') {
                while (stack.peek() != '(') postfix.add(Character.toString(stack.pop()));
                stack.pop();
            } else if (ch == ' ') continue;
            else {
                StringBuilder num = new StringBuilder();
                while (Character.isDigit(ch)) {
                    num.append(ch);
                    i++;
                    if (i == s.length()) break;
                    ch = s.charAt(i);
                }
                i--;
                postfix.add(num.toString());
            }
        }
        while (!stack.isEmpty()) postfix.add(Character.toString(stack.pop()));
        for (String ss : postfix) System.out.print(" " + ss);
        return evalRPN(postfix);
    }

    private int evalRPN(List<String> tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+") || s.equals("-")) {
                if (stack.size() == 1) {
                    int sign = s.equals("+") ? 1 : -1;
                    stack.push(stack.pop() * sign);
                } else {
                    int deno = stack.pop();
                    int num = stack.pop();
                    int ans;
                    if (s.equals("+")) ans = num + deno;
                    else ans = num - deno;
                    stack.push(ans);
                }
            } else stack.push(Integer.parseInt(s));
        }
        return stack.pop();
    }
}