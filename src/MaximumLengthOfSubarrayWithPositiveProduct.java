public class MaximumLengthOfSubarrayWithPositiveProduct {
    public int getMaxLen(int[] nums) {
        if(nums.length==0) return 0;
        int posStart=-1,negStart=-1;
        if(nums[0]>0) posStart=0;
        else if(nums[0]<0) negStart=0;

        int prod=1,max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            prod*=nums[i];
        if(nums[i]==0) {
            max = Math.max(max, i - posStart-1);
            prod = 1;
        }
        else if(prod>0){
            if(posStart==Integer.MAX_VALUE){
                posStart=i;
                continue;
            }
            max = Math.max(max, i - posStart-1);
        }
        else if(prod<0){
            negStart=i;
            posStart=Integer.MAX_VALUE;
        }

        }
        return max;
    }
}
