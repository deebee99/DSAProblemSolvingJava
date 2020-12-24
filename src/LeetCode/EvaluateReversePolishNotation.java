package LeetCode;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
            Stack<Integer> stack=new Stack<>();
            for(String s : tokens){
                if(s.equals("+")||s.equals("-")||s.equals("/")|| s.equals("*")){
                    int deno=stack.pop();
                    int num=stack.pop();
                    int ans;
                    if(s.equals("+")) ans=num+deno;
                    else if(s.equals("-")) ans=num-deno;
                    else if(s.equals("*")) ans=num*deno;
                    else ans=num/deno;
                    stack.push(ans);
                }
                else stack.push(Integer.parseInt(s));
            }
            return stack.pop();
    }
}
