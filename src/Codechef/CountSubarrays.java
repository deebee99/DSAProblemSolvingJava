package Codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountSubarrays {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            int n=Integer.parseInt(br.readLine());
            long arr[]=new long[n];
            String line = br.readLine();
            String[] strs = line.trim().split(" ");
            for (int i = 0; i < n; i++) arr[i] =Long.parseLong(strs[i]);
            long count=0;
            long len=1;
            for(int i=1;i<n;i++){
                count+=len;
                if(arr[i]>=arr[i-1]) len++;
                else {
                    System.out.println(len+" "+count);
                    len=1;
                }
            }
            System.out.println(count+len);
        }
    }
}
