package LeetCode;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        int flag = (long) (dividend) * divisor < 0 ? -1 : 1;
        long ret = flag * dividePositive(Math.abs((long) dividend), Math.abs((long) divisor));
        return (int) ((ret > (long) Integer.MAX_VALUE || ret < (long) Integer.MIN_VALUE) ? Integer.MAX_VALUE : ret);
    }


    private long dividePositive(long dividend, long divisor) {
        long l = 0, r = dividend;
        while (l <= r) {
            long m = l + (r - l) / 2;
            long t = m * divisor;
            if (t == dividend) return m;
            if (t < dividend) l = m + 1;
            else r = m - 1;
        }
        return l * divisor > dividend ? l - 1 : l;
    }
}
