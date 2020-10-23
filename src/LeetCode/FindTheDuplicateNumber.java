package LeetCode;

public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums){
        for(int n : nums) {
            int value = n > 0 ? n : n * (-1);
            nums[value] *= -1;
            if(nums[value]>0) return value;
        }
        return -1;
    }
}
