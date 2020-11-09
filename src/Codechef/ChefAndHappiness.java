package Codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ChefAndHappiness {
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0) {
            t--;
            Map<Integer,Integer> map=new HashMap<>();
            Set<Integer> set=new HashSet<>();
            final int n=Integer.parseInt(br.readLine());
            final String strs[] = br.readLine().split(" ");
            int index = 1,flag=0;
            int arr[] = new int[strs.length+1];

            for (String s : strs) arr[index++] = Integer.parseInt(s);
            for(int i : arr){
                if(set.contains(i)) continue;
                map.put(arr[i],map.getOrDefault(arr[i],0)+1);
                if(map.get(arr[i])==2){
                    flag=1;
                    System.out.println("Truly Happy");
                    break;
                }
                set.add(i);
                }

            if(flag==0) System.out.println("Poor Chef");
        }
    }
}
