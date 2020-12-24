package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BasicCalculatorII {
    /**
     * Method 1
     * Infix to Postfix conversion - > evaluate postfix expression.
     *
     * @param s
     * @return
     */
    public int calculate(String s) {
        List<String> postfix = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (!stack.isEmpty() && stack.peek() != '(' && getPriority(stack.peek()) >= getPriority(ch))
                    postfix.add(Character.toString(stack.pop()));
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

        return evalRPN(postfix);
    }

    private int getPriority(Character op) {
        if (op.equals('+') || op.equals('-')) return 1;
        else if (op.equals('*') || op.equals('/')) return 2;
        return -1;
    }

    private int evalRPN(List<String> tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*")) {
                int deno = stack.pop();
                int num = stack.pop();
                int ans;
                if (s.equals("+")) ans = num + deno;
                else if (s.equals("-")) ans = num - deno;
                else if (s.equals("*")) ans = num * deno;
                else ans = num / deno;
                stack.push(ans);
            } else stack.push(Integer.parseInt(s));
        }
        return stack.pop();
    }

    /**
     * Method 2 :
     * Solve in one loop (Ref : LeetCode Solutions)
     */
    public int calculate2(String s) {

        int len = s.length();
        if (s == null || len == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int currentNumber = 0;
        char operation = '+';
        for (int i = 0; i < len; i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == len - 1) {
                if (operation == '-') {
                    stack.push(-currentNumber);
                } else if (operation == '+') {
                    stack.push(currentNumber);
                } else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                } else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber);
                }
                operation = currentChar;
                currentNumber = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}