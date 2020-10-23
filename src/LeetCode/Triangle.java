package LeetCode;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Triangle {

    int n;
    HashMap<Pair<Integer,Integer>,Integer> map=new HashMap<>();
    public int minimumTotal(List<List<Integer>> triangle) {
        n = triangle.size();
        if(n==0) return 0;
        if(n==1) return triangle.get(0).get(0);
        int minValue[] = new int[n];
        int maxValue = 0;

        for (List<Integer> list : triangle) {
            int tempMax = list.get(0);
            for (int i : list) tempMax = Math.max(tempMax, i);
            maxValue += tempMax;
        }
//        dp = new int[maxValue][];
//        for (int i = 0; i < maxValue; i++) {
//            dp[i] = new int[n + 1];
//            Arrays.fill(dp[i], Integer.MAX_VALUE);
//        }
        return calc(triangle, 1, 0, triangle.get(0).get(0));

    }

    private int calc(List<List<Integer>> triangle, int index, int prevIndex, int sumSoFar) {
        System.out.println(sumSoFar + " "+ index + " "+ prevIndex);

        if(index==n) return sumSoFar;
        if (index > n) return Integer.MAX_VALUE;

        Pair pair=new Pair<Integer, Integer>(sumSoFar,index);
        if (map.containsKey(pair)) return map.get(pair);
        int temp = Integer.MAX_VALUE;
        if (prevIndex + 1 <= index)
            temp = calc(triangle, index + 1, prevIndex + 1, sumSoFar + triangle.get(index).get(prevIndex + 1));
        if (prevIndex >= 0)
            temp = Math.min(temp, calc(triangle, index + 1, prevIndex, sumSoFar + triangle.get(index).get(prevIndex)));
        map.put(pair,temp);
        return temp;

    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<4;i++) list.add(new ArrayList<Integer>());

        list.get(0).add(1);

        list.get(1).add(-2);
        list.get(1).add(-5);

        list.get(2).add(3);
        list.get(2).add(6);
        list.get(2).add(9);

        list.get(3).add(-1);
        list.get(3).add(2);
        list.get(3).add(4);
        list.get(3).add(-3);

        int ans = new Triangle().minimumTotal(list);
        System.out.println(ans);

    }
}