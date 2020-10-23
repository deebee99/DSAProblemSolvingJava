package LeetCode;

import java.util.*;

public class FriendsOfAppropriateAges {
    public int numFriendRequests(int[] ages) {
        TreeMap<Integer,Integer> treeMap=new TreeMap<>();
        int requests = 0;
        for(int age : ages) treeMap.put(age,treeMap.getOrDefault(age,0)+1);
        List<Integer> list=new ArrayList<>();
        System.out.println(treeMap.keySet());
        list.addAll(treeMap.keySet());
        for (int i=0;i<list.size();i++) {
            int lowerLimit = (list.get(i) / 2) + 7;
            int temp=treeMap.get(list.get(i))-1;
            for (int j = i - 1; j >= 0 && list.get(j) > lowerLimit; j--) temp+=treeMap.get(list.get(j));
            requests+=temp;
            System.out.println(lowerLimit+" "+list.get(i)+" "+temp);

            System.out.println(i+" "+requests);
        }
        return requests;
    }
}
