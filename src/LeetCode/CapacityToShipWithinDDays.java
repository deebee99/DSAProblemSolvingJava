package LeetCode;

import java.util.Arrays;

public class CapacityToShipWithinDDays {
    public int shipWithinDays(int[] weights, int D) {

        int sum=0,max=0;
        for(int w:weights){
            sum+=w;
            max=Math.max(max,w);
        }
        int low=max,high=sum,ans=-1;
        while(low<=high){

            int mid=low+(high-low)/2;
            if(possible(weights,D,mid)){
                high=mid-1;
                ans=mid;
            }
            else low=mid+1;
        }
        return ans;
    }

    private boolean possible(int[] weights, int d, int mid) {
        int days=1,sum=0;
        for(int w: weights){
            if(w>mid) return false;
            sum+=w;
            if(sum>mid){
                days++;
                sum=w;
            }
        }
        if(days>d) return false;
        return true;
    }
}
