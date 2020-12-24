package LeetCode;

import java.util.Stack;

public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        Stack<Character> stack=new Stack<>();
        for(char ch : num.toCharArray()){
            while(k>0 && !stack.isEmpty() && stack.peek()>ch){
                stack.pop();
                k--;
            }
            stack.push(ch);
        }
        while(k>0) {
            stack.pop();
            k--;
        }
        StringBuilder stringBuilder=new StringBuilder();
        while(!stack.isEmpty()) stringBuilder.append(stack.pop());
        stringBuilder.reverse();
        while(stringBuilder.length()>1 && stringBuilder.charAt(0)=='0') stringBuilder.deleteCharAt(0);
        return stringBuilder.toString();
    }
}
