package LeetCode;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class KthSmallestPrimeFraction {
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
    int ans[]=new int[2];
    int n=A.length;
        HashMap<Double, Pair<Integer,Integer>> hashMap=new HashMap<>();
        PriorityQueue<Double> pq=new PriorityQueue<>();
        Arrays.sort(A);
    for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
            Double temp=(double)A[i]/A[j];
            pq.add(temp);
            hashMap.put(temp,new Pair<>(A[i],A[j]));
        }
    }
    while(K>0){
        pq.poll();
        K--;
    }
    ans[0]=hashMap.get(pq.peek()).getKey();
    ans[1]=hashMap.get(pq.peek()).getValue();
    return ans;
    }
}
