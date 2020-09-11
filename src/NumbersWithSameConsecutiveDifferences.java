import java.util.ArrayList;
import java.util.List;

public class NumbersWithSameConsecutiveDifferences {
    List <Integer> temp=new ArrayList<>();
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> list=new ArrayList<>();
        for(int i=1;i<=9;i++){
            find(i,i,n,k,1);
        }

        int[] ans=new int[temp.size()];
        for(int i=0;i<temp.size();i++) ans[i]=temp.get(i);
        return ans;
    }

    private void find(int num, int digit,int n, int k,int len) {
        if(digit<0 || digit>9 || len>n) return;
        if(len==n) temp.add(num);
        find(num*10+digit-k,digit-k,n,k,len+1);
        find(num*10+digit+k,digit+k,n,k,len+1);
    }

    public static void main(String[] args) {
        NumbersWithSameConsecutiveDifferences numbers=new NumbersWithSameConsecutiveDifferences();
        numbers.numsSameConsecDiff(2,1);
    }
}

