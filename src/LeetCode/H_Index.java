package LeetCode;

import java.util.*;

public class H_Index {
    public int hIndex(int[] citations) {
        int size = citations.length;
        if (size==0) return 0;
        Integer temp[]=new Integer[size];
        for(int i=0;i<size;i++) temp[i]=citations[i];
        Arrays.sort(temp, Collections.reverseOrder());

        int i = 0;
        while(i<size && temp[i]>=i+1){
            i++;
        }

        return i;
    }

    public static void main(String[] args) {
        H_Index h_index=new H_Index();
        int[] arr={3,0,6,1,1};
        System.out.println(h_index.hIndex(arr));
    }
}
