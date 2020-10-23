package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    List <String> result=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        String s="";
    generate(0,0,n,s);
    return result;
    }

    private void generate(int left, int right, int n, String s) {
        if(left+right>n*2) return;
        if(left+right==n*2){
            if(left==right) result.add(new String(s));
            return;
        }
        if(left<n)
        generate(left+1,right,n,s+'(');
        if(right<left)
            generate(left,right+1,n,s+')');
    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis=new GenerateParenthesis();
        generateParenthesis.generateParenthesis(3);
        for(String s:generateParenthesis.result){
            System.out.println(s);
        }
    }

}
