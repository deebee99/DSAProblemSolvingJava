import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LargestComponentSizeByCommonFactor {
    HashMap<Integer, List<Integer>> hashMap=new HashMap<>();
    HashMap<Integer,Integer> visited=new HashMap<>();

    public int largestComponentSize(int[] arr) {

        for(int i : arr) {
            List<Integer> temp = new ArrayList<>();
            hashMap.put(i, temp);
            visited.put(i,0);
        }
        for (int i = 0; i <arr.length ; i++) {
            for (int j = i+1; j < arr.length; j++) {
                int gcd=calcGCD(arr[i],arr[j]);
                if(gcd!=1){
                    hashMap.get(arr[i]).add(arr[j]);
                    hashMap.get(arr[j]).add(arr[i]);
                }
            }
        }
      int maxSizeComp=Integer.MIN_VALUE;
        for(int i:arr){
          if(visited.get(i)==0){
             maxSizeComp=Integer.max(maxSizeComp,dfs(i));
          }
        }
        return maxSizeComp;
    }

    private int dfs(int i) {
        if(visited.get(i)==1) return 0;
        visited.put(i,1);
        for(int j : hashMap.get(i)){
            if(visited.get(j)==0){
                return 1+dfs(j);
            }
        }
        return 1;
    }

    private int calcGCD(int a, int b) {
        if(b==0) return a;
        return calcGCD(b,a%b);
    }

}
