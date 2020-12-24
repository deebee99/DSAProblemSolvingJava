package LeetCode;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;

        if (n1 == 0 && n2 == 0) return (double) 0;
        if ((n1 + n2) == 1) {
            if (n1 == 1) return nums1[0];
            return nums2[0];
        }

        int[] nums = new int[n1 + n2];
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < n1 && j < n2) {
            if (nums1[i] < nums2[j]) {
                nums[index++] = nums1[i++];
            } else {
                if (nums2[j] == nums1[i]) {
                    nums[index++] = nums1[i++];
                }
                nums[index++] = nums2[j++];
            }
        }

        while (i < n1) {
            nums[index++] = nums1[i++];
        }
        while (j < n2) {
            nums[index++] = nums2[j++];
        }
        double median = 0.0 + nums[(n1 + n2) / 2];
        if ((n1 + n2) % 2 == 0) {
            median += nums[(n1 + n2) / 2 - 1];
            median = median / 2;
        }
        return median;
    }

    /**
     *  log (min(n1, n2)) solution
     */

    int[] nums1;
    int[] nums2;

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;

        if (n1 == 0 && n2 == 0) return (double) 0;
        if ((n1 + n2) == 1) {
            if (n1 == 1) return nums1[0];
            return nums2[0];
        }

        this.nums1 = n1 < n2 ? nums1 : nums2;
        this.nums2 = n2 > n1 ? nums2 : nums1;

        return findMedian();
    }

    private double findMedian() {
        int start = 0;
        int end = nums1.length;
        int n1 = nums1.length;
        int n2 = nums2.length;

        while (start < end) {
            int x = start + (end - start) / 2;
            int y = ((n1 + n2 + 1) / 2) - x;
            int x1 = x == 0 ? Integer.MIN_VALUE : nums1[x];
            int y1 = y == 0 ? Integer.MIN_VALUE : nums2[y];
            int x2 = x == (n1 - 1) ? Integer.MAX_VALUE :nums1[x + 1];
            int y2 = (y == n2 - 1) ? Integer.MAX_VALUE : nums2[y + 1];
            if (x1 <= y2 && y1 <= x2) {
                double median = Math.max(x1, y1);
                if ((n1 + n2) % 2 == 0) {
                    median += Math.min(x2, y2);
                }
                return median;
            }
            else if (x1 > y2) {
                start = x - 1;
            }
            else {
                end = x + 1;
            }
        }
        return - 1;
    }
}
