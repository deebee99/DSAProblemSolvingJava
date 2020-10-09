import java.util.Arrays;

public class SpecialArrayWithXElementsGreaterThanorEqualX {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int pos = 1;
        for (int i = 0; i < nums.length; i++) {
            for (; pos <= nums[i]; pos++) {
                if (pos == nums.length - i) return pos;
            }
        }
        return -1;
    }
}
