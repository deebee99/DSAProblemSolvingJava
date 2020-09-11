import java.util.HashMap;
//doesnt check integer overflow condition
public class NumberOfWaysWhereSquareOfNumberIsEqualToProductOfTwoNumbers {
    private int count=0;
    private  HashMap<Long,Long> nums1ElementsSquare=new HashMap<>();
    private  HashMap<Long,Long> nums2ElementsSquare=new HashMap<>();

    public int numTriplets(int[] nums1, int[] nums2) {

        for(int i : nums1) nums1ElementsSquare.merge((long) (i*i),1l,Long::sum);

        for(int i : nums2) nums2ElementsSquare.merge((long) (i*i),1l,Long::sum);

        count = getCount(nums2,nums1ElementsSquare);

        count = getCount(nums1,nums2ElementsSquare);
        return count;
    }

    private int getCount(int[] nums,HashMap<Long, Long> numsElementsSquare) {
        for(int i = 0; i< nums.length; i++){
            for(int j = i+1; j< nums.length; j++){
                long prod= nums[i]* nums[j];
                if(numsElementsSquare.containsKey(prod)) count+=numsElementsSquare.get(prod);
            }
        }
        return count;
    }
}
