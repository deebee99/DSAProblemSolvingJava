package LeetCode;

public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        int n=s.length();
        if(n<=1) return false;
        String r=s+s;
        return r.substring(1,2*n-1).contains(s);
    }

    public static void main(String[] args) {
        RepeatedSubstringPattern repeatedSubstringPattern=new RepeatedSubstringPattern();
        String s="aabaaba";
        System.out.println(repeatedSubstringPattern.repeatedSubstringPattern(s));
    }
}
